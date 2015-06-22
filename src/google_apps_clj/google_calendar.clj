(ns google-apps-clj.google-calendar
  (:require [clojure.core.typed :as t]
            [clojure.core.typed.unsafe :as tu]
            [clojure.edn :as edn :only [read-string]]
            [clojure.java.io :as io :only [as-url file resource]]
            [google-apps-clj.credentials :as cred])
  (:import (com.google.api.services.calendar Calendar
                                             Calendar$Builder
                                             CalendarScopes)))

(t/ann build-calendar-service [cred/GoogleCtx -> Calendar])
(defn build-calendar-service
  "Given a google-ctx configuration map, builds a Calendar service using
  credentials coming from the OAuth2.0 credential setup inside googlectx"
  [google-ctx]
  (let [calendar-builder (->> google-ctx
                           cred/build-credential
                           (Calendar$Builder. cred/http-transport cred/json-factory))]
    (cast Calendar (doto (.build calendar-builder)
                     assert))))

(t/ann ^:no-check add-calendar-event [cred/GoogleCtx String String String String String (t/Coll String) -> t/Any])
(defn add-calendar-event
  ""
  [google-ctx summary description location start-time end-time attendees])
