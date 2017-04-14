(ns firmata-test.core
  (:require [clodiuno.core :refer :all]
            [clodiuno.firmata :refer :all]))

(defn -main []
  (let [board (arduino :firmata "/dev/tty.wchusbserial1450")]
    ;;allow arduino to boot
    (Thread/sleep 1000)
    (pin-mode board 0 OUTPUT)
    (while true
        (doseq [x (list 0)]
          (println x)
          (println "HIGH")
          (digital-write board x HIGH)
          (Thread/sleep 6000)
          (println x)
          (println "LOW")
          (digital-write board x LOW))
          (Thread/sleep 6000))
    (close board)))
