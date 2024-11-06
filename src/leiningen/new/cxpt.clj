(ns leiningen.new.cxpt
  (:require [leiningen.new.templates :as tmpl]
            [leiningen.core.main :as main]))

(def render (tmpl/renderer "cxpt"))

(defn cxpt
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (tmpl/name-to-path name)}]
    (main/info "Generating fresh 'lein new' dmr/cxpt project.")
    (tmpl/->files data
                  [".gitignore" (render "dot.gitignore" data)]
                  ["project.clj" (render "project.clj" data)]
                  ["core_test.clj" (render "core_test.clj" data)]
                  ["core.clj" (render "core.clj" data)])))
