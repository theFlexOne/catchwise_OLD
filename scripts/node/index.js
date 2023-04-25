import axios from "axios";
import fs from "fs";
import scrapeFishBase from "./scripts/scrapeFishBase.js";
import { fetchFishDataList } from "./scripts/fetchFishData.js";

const rods = JSON.parse(fs.readFileSync("./data/rodData.json", "utf8"));

rods.forEach(rod => rod.name = rod.name.toLowerCase().trim())
fs.writeFileSync("./data/rodData.json", JSON.stringify(rods, null, 2));

fetchFishDataList().then(data => fs.writeFileSync("./data/fishData.json", JSON.stringify(data, null, 2)));


/*
const urlList = [
  {
    url: "https://www.takemefishing.org/freshwater-fishing/freshwater-fishing-gear/freshwater-tackle/",
    filename: "freshwater-tackle",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/freshwater-fishing-gear/rods/",
    filename: "freshwater-rods",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/types-of-freshwater-fishing/lakes-and-ponds/",
    filename: "freshwater-lakes-and-ponds",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/types-of-freshwater-fishing/river-fishing/",
    filename: "freshwater-river-fishing",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/types-of-freshwater-fishing/lake-fishing/",
    filename: "freshwater-lake-fishing",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/types-of-freshwater-fishing/pond-fishing/",
    filename: "freshwater-pond-fishing",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/types-of-freshwater-fishing/reservoirs-and-flowages/",
    filename: "freshwater-reservoirs-and-flowages",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/when-to-freshwater-fish/best-time-to-fish-trout/",
    filename: "freshwater-best-time-to-fish-trout",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/when-to-freshwater-fish/best-time-to-fish-for-bass/",
    filename: "freshwater-best-time-to-fish-for-bass",
  },
  {
    url: "https://www.takemefishing.org/freshwater-fishing/when-to-freshwater-fish/best-time-to-freshwater-fish/",
    filename: "freshwater-best-time-to-freshwater-fish",
  },
];
const filepath = "freshwater-bait.html";

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

async function run() {
  scrapeFishBase();
}
*/