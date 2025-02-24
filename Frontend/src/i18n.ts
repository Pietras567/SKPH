import { initReactI18next } from "react-i18next";
import i18n from "i18next";

import enJSON from "./locale/en.json";
import plJSON from "./locale/pl.json";

i18n.use(initReactI18next).init({
  debug: true,

  resources: {
    en: { ...enJSON },
    pl: { ...plJSON },
  },
  lng: "en",
});
