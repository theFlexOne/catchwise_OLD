import fs from "fs";
import scrapeFishBase from "./scripts/scrapeFishBase.js";

const fishBaseListOLD = JSON.parse(
  fs.readFileSync("./data/fishBaseFishListOLD.json", "utf8")
);
const fishBaseList = JSON.parse(
  fs.readFileSync("./data/fishBaseFishList.json", "utf8")
);
const masterFishList = JSON.parse(
  fs.readFileSync("./data/fishData.json", "utf8")
);
const newFishData = JSON.parse(
  fs.readFileSync("./data/fishDataNew.json", "utf8")
);

const filteredNewFishData = newFishData.filter((fish, i) => {
  if (!fish.commonNames) {
    console.log("fish", i, fish.name);
  }
  return fish.commonNames;
});

function buildNewFishDataJSON(masterFishList, fishBaseList) {
  const newFishData = masterFishList.map((fish) => {
    const fishBaseFish = fishBaseList.find((fishBaseFish) => {
      return fishBaseFish.commonNames.includes(fish.name.toLowerCase());
    });
    if (fishBaseFish) {
      return {
        ...fish,
        ...fishBaseFish,
      };
    } else {
      return fish;
    }
  });

  fs.writeFileSync(
    "./data/fishDataNew.json",
    JSON.stringify(newFishData, null, 2)
  );
}

function formatFishBaseFishData(fishBaseList) {
  fishBaseList.forEach((fishBaseFish) => {
    let { commonNames, species: speciesAndGenus, family } = fishBaseFish;

    commonNames = commonNames
      .replaceAll(/ \(\w*\)/g, "")
      .trim()
      .toLowerCase();
    const commonNameList = commonNames.split(", ");
    fishBaseFish.commonNames = commonNameList;

    const [genus, species] = speciesAndGenus.toLowerCase().trim().split(" ");
    fishBaseFish.genus = genus;
    fishBaseFish.species = species;

    fishBaseFish.family = family.toLowerCase();

    delete fishBaseFish.commonName;
    delete fishBaseFish.info;
    delete fishBaseFish.abundance;
    delete fishBaseFish.maxLength;
    delete fishBaseFish.maturity;
  });

  fs.writeFileSync(
    "./data/fishBaseFishList.json",
    JSON.stringify(fishBaseList, null, 2)
  );
}

function sortFishBaseIds() {
  const fishBaseIds = JSON.parse(
    fs.readFileSync("./data/fishBaseFishLinks.json", "utf8")
  );
  const sortedFishBaseIds = fishBaseIds.sort((a, b) => a - b);
  fs.writeFileSync(
    "./data/fishBaseFishLinks.json",
    JSON.stringify(sortedFishBaseIds)
  );
}

sortFishBaseIds();
