import scrapeFishingLakesAndPonds from "./scripts/fishing-types/scrapeFishingLakesAndPonds.js";
import scrapeFreshwaterLakeFishing from "./scripts/fishing-types/scrapeFreshwaterLakeFishing.js";
import scrapeFreshwaterPondFishing from "./scripts/fishing-types/scrapeFreshwaterPondFishing.js";
import scrapeFreshwaterResevoirsAndFlowages from "./scripts/fishing-types/scrapeFreshwaterResevoirsAndFlowages.js";
import scrapeFreshwaterTackle from "./scripts/scrapeFreshwaterTackle.js";

const fishingLakesAndPonds = scrapeFishingLakesAndPonds(html);
const freshwaterLakeFishing = scrapeFreshwaterLakeFishing();
const freshwaterPondFishing = scrapeFreshwaterPondFishing();
const freshwaterResevoirsAndFlowages = scrapeFreshwaterResevoirsAndFlowages();

const freshwaterTackle = scrapeFreshwaterTackle();

// console.log(fishingLakesAndPonds);
// console.log(freshwaterLakeFishing);
// console.log(freshwaterPondFishing);
// console.log(freshwaterResevoirsAndFlowages);

console.log(freshwaterTackle);
