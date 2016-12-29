(ns meetup
  (:import (java.util Calendar))
  (:import (java.util Date))
  (:import (java.text SimpleDateFormat)))

(.getName String)

(System/getProperty "java.vm.version")

;; Calendar Library

;; This looks like normal Clojure
(Calendar/getInstance)
;; #inst "2016-12-28T18:29:24.301+00:00"

;; Whereas the dot operator acts like 'new'
(. Calendar (getInstance))
(. (Calendar/getInstance) getTimeZone)

;; It's possible to chain methods using double dots
(.. (Calendar/getInstance) (getTimeZone))
;; #<ZoneInfo sun.util.calendar.ZoneInfo[id="Europe/London",offset=0,dstSavings=3600000,useDaylight=true,transitions=242,lastRule=java.util.SimpleTimeZone[id=Europe/London,offset=0,dstSavings=3600000,useDaylight=true,startYear=0,startMode=2,startMonth=2,startDay=-1,startDayOfWeek=1,startTime=3600000,startTimeMode=2,endMode=2,endMonth=9,endDay=-1,endDayOfWeek=1,endTime=3600000,endTimeMode=2]]>

(.. (Calendar/getInstance) (getTime))
;; #inst "2016-12-28T18:32:45.732-00:00"

(.. (Calendar/getInstance) (getTimeZone) (getDisplayName))
;; "Greenwich Mean Time"

;; Creating a binding (corrent terminology?) is standard
(def cal (Calendar/getInstance))
(.getTimeZone cal)

;; Date Library

(def date (Date.))
(def hours (.. (Date.) (getHours)))
(.. (Date.) (getMinutes))
(.getHours date)

;; Simple Date Format Library

(def sdf (SimpleDateFormat. "dd/MM/yyyy"))
(.parse sdf "25/12/2016")
;; #inst "2016-12-25T00:00:00.000-00:00"

(type (.parse sdf "25/12/2016"))
;; java.util.Date

(.parse (SimpleDateFormat. "dd/MM/yyyy") "25/12/2016")
;; #inst "2016-12-25T00:00:00.000-00:00"

(.. (SimpleDateFormat. "dd/MM/yyyy") (parse "25/12/2016"))
;; #inst "2016-12-25T00:00:00.000-00:00"

(.get2DigitYearStart sdf)
;; #inst "1936-12-28T18:20:42.705-00:00"

;; more stuff

(def now (Calendar/getInstance))

;; (Calendar/DECEMBER)
;; (Calendar/DAY_OF_MONTH)

(def year (.get now Calendar/YEAR))
(def week (.get now Calendar/MONTH))
(def day (.get now Calendar/DAY_OF_WEEK))
(println (format "%s %s %s" year week day))

(.getTimeZone now)
(map (memfn toString) (Calendar/getAvailableLocales))

(def my-locale (Locale. "GB"))
(def my-timezone (.getTimeZone now))
(.. (.getDisplayName now Calendar/MONTH Calendar/SHORT my-locale) (toString))
(. (. (Calendar/getInstance) (getTimeZone)) (getDisplayName))
(.. (Calendar/getInstance) (getTimeZone) (getDisplayName))
(.getDisplayName (.getTimeZone (Calendar/getInstance)))

(def cal (Calendar/getInstance))
(.set cal 2016 11 1)

(def new-year (.get cal (Calendar/YEAR)))
(def new-month (.get cal (Calendar/MONTH)))
(def new-day (.get cal (Calendar/DAY_OF_WEEK)))
(println (format "%s %s %s" new-year new-month new-day))

