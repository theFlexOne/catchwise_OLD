import axios from "axios";
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

function runOld() {
  const baitList = getFishingBaitList();
  console.log(baitList);
  fs.writeFileSync("./baitData.json", JSON.stringify(baitList, null, 2));
}

async function run() {
  const fetchList = urlList.map(({ url }) => axios.get(url));
  const responses = await Promise.all(fetchList);
  const htmlList = responses.map(({ data }) => data);
  htmlList.forEach((html, index) => {
    fs.writeFileSync(`./html/${urlList[index].filename}.html`, html);
  });
}

run();
