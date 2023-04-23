import fs from "fs";

import fetchLakeDataList from "./fetchLakeData.js";
import { fetchFishDataList } from "./fetchFishData.js";
import { scrapeBaitData } from "./scrapeBaitData.js";

// const fishData = fs.readFileSync("fishData.json", "utf8");
// fishData.data.forEach((fish) => {
//   const habitats = fish.geography.habitat.split(", ");
//   fish.geography.habitat = habitats;
// });
// fs.writeFileSync("fishData.json", JSON.stringify(fishData, null, 2));

function getFishingBaitList() {
  const baitList = new Set();
  const fishes = JSON.parse(fs.readFileSync("./fishData.json", "utf8"));
  fishes.forEach((fish) => {
    fish.bait.items.forEach((bait) => {
      baitList.add(bait.name);
    });
  });
  return [...baitList].sort();
}

const baitList = getFishingBaitList();
console.log(baitList);
fs.writeFileSync("./baitData.json", JSON.stringify(baitList, null, 2));

