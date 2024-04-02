package io.github.debuggyteam.architecture_extensions.blocks;

import com.mojang.serialization.MapCodec;
import io.github.debuggyteam.architecture_extensions.api.BlockType.TypedGroupedBlock;
import net.minecraft.block.AbstractLichenBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LichenSpreadBehavior;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.MutableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

/**
 * @author Gaming32 & Portal Cubed devs
 * @since arch-ex v2.1.0-1.19.4
 **/
public class FacadeBlock extends AbstractLichenBlock implements TypedGrouped {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	protected final TypedGroupedBlock typedGroupedBlock;
	
	public FacadeBlock(Settings settings, TypedGroupedBlock typedGroupedBlock) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false)); // Thanks LambdAurora!
		this.typedGroupedBlock = typedGroupedBlock;
	}

	public FacadeBlock(Block baseBlock, Settings settings, TypedGroupedBlock typedGroupedBlock) {
		this(settings, typedGroupedBlock);
	}
	
	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
		return VoxelShapes.empty();
	}

	@Override
	public LichenSpreadBehavior getLichenSpreadBehavior() {
		return new LichenSpreadBehavior(this);
	}
	
	@Override
	public boolean canReplace(BlockState state, ItemPlacementContext ctx) {
		return ctx.getStack().isOf(this.asItem());
	}

	// Deals with block waterlogging. Thanks acikek!
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : Fluids.EMPTY.getDefaultState();
	}

	@Override
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
		if (state.get(WATERLOGGED)) world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));

		return state;
	}
	
	@Override
	protected MapCodec<? extends AbstractLichenBlock> getCodec() {
		return null;
	}
	
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(WATERLOGGED);
	}

	@Override
	public TypedGroupedBlock getTypedGroupedBlock() {
		return typedGroupedBlock;
	}
	
	@Override
	public MutableText getName() {
		return getServerTranslation();
	}
}
