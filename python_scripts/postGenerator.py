import json
import os

from python_scripts.anApiThingy import ROOT_DIR

# block_category = input("Input category name: ")
arch_ex_block = input("Input Arch-Ex block name: ")
minecraft_block = input("Input Minecraft block name: ")
namespace = input("Input mod namespace or skip if you're using the \"minecraft:\" namespace: ")

if len(namespace) == 0:
    namespace = "minecraft"

blockstate_dict = {
    "variants": {
        "axis=x": {
            "model": f"architecture_extensions:block/posts/{arch_ex_block}_post",
            "x": 90,
            "y": 90
        },
        "axis=y": {
            "model": f"architecture_extensions:block/posts/{arch_ex_block}_post"
        },
        "axis=z": {
            "model": f"architecture_extensions:block/posts/{arch_ex_block}_post",
            "x": 90
        }
    }
}

post_model = {
    "parent": "architecture_extensions:block/templates/template_wall_post_block",
    "textures": {
        "texture": f"{namespace}:block/{minecraft_block}"
    }
}

item_dict = {
    "parent": f"architecture_extensions:block/posts/{arch_ex_block}_post"
}

wall_to_post_recipe = {
    "type": "minecraft:crafting_shapeless",
    "ingredients": [
        {
            "item": f"{namespace}:{minecraft_block}_wall"
        }
    ],
    "result": {
        "item": f"architecture_extensions:{arch_ex_block}_post",
        "count": 1
    }
}

post_to_wall_recipe = {
    "type": "minecraft:crafting_shapeless",
    "ingredients": [
        {
            "item": f"architecture_extensions:{arch_ex_block}_post"
        }
    ],
    "result": {
        "item": f"{namespace}:{minecraft_block}_wall",
        "count": 1
    }
}

files = [blockstate_dict, post_model, item_dict]
directories = [
    "assets\\architecture_extensions\\blockstates",
    "assets\\architecture_extensions\\models\\block\\posts",
    "assets\\architecture_extensions\\models\\item",
]

for i, j in zip(files, directories):
    os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\{j}")
    with open(f"{arch_ex_block}_post.json", "w") as file:
        json.dump(i, file, indent=4)
        file.close()

os.chdir(f"{ROOT_DIR}\\src\\main\\resources\\data\\architecture_extensions\\recipes")
with open(f"{arch_ex_block}_wall_to_post.json", "w") as file:
    json.dump(wall_to_post_recipe, file, indent=4)
    file.close()
with open(f"{arch_ex_block}_post_to_wall.json", "w") as file:
    json.dump(post_to_wall_recipe, file, indent=4)
    file.close()
print(f"Files for {arch_ex_block.title()} Post have been generated")
