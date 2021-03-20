;;;----------------------------------------------------------------------------------
;;; Generated by protoc-gen-clojure.  DO NOT EDIT
;;;
;;; Message Implementation of package helloworld
;;;----------------------------------------------------------------------------------
(ns helloworld
  (:require [protojure.protobuf.protocol :as pb]
            [protojure.protobuf.serdes.core :as serdes.core]
            [protojure.protobuf.serdes.complex :as serdes.complex]
            [protojure.protobuf.serdes.utils :refer [tag-map]]
            [protojure.protobuf.serdes.stream :as serdes.stream]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]))

;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------
;; Forward declarations
;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------

(declare cis->HelloRequest)
(declare ecis->HelloRequest)
(declare new-HelloRequest)
(declare cis->HelloReply)
(declare ecis->HelloReply)
(declare new-HelloReply)


;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------
;; Message Implementations
;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------

;-----------------------------------------------------------------------------
; HelloRequest
;-----------------------------------------------------------------------------
(defrecord HelloRequest-record [name]
  pb/Writer
  (serialize [this os]
    (serdes.core/write-String 1  {:optimize true} (:name this) os))
  pb/TypeReflection
  (gettype [this]
    "helloworld.HelloRequest"))

(s/def :helloworld.HelloRequest/name string?)
(s/def ::HelloRequest-spec (s/keys :opt-un [:helloworld.HelloRequest/name ]))
(def HelloRequest-defaults {:name "" })

(defn cis->HelloRequest
  "CodedInputStream to HelloRequest"
  [is]
  (->> (tag-map HelloRequest-defaults
         (fn [tag index]
             (case index
               1 [:name (serdes.core/cis->String is)]

               [index (serdes.core/cis->undefined tag is)]))
         is)
        (map->HelloRequest-record)))

(defn ecis->HelloRequest
  "Embedded CodedInputStream to HelloRequest"
  [is]
  (serdes.core/cis->embedded cis->HelloRequest is))

(defn new-HelloRequest
  "Creates a new instance from a map, similar to map->HelloRequest except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::HelloRequest-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::HelloRequest-spec init))))]}
  (-> (merge HelloRequest-defaults init)
      (map->HelloRequest-record)))

(defn pb->HelloRequest
  "Protobuf to HelloRequest"
  [input]
  (cis->HelloRequest (serdes.stream/new-cis input)))

(def ^:protojure.protobuf.any/record HelloRequest-meta {:type "helloworld.HelloRequest" :decoder pb->HelloRequest})

;-----------------------------------------------------------------------------
; HelloReply
;-----------------------------------------------------------------------------
(defrecord HelloReply-record [message]
  pb/Writer
  (serialize [this os]
    (serdes.core/write-String 1  {:optimize true} (:message this) os))
  pb/TypeReflection
  (gettype [this]
    "helloworld.HelloReply"))

(s/def :helloworld.HelloReply/message string?)
(s/def ::HelloReply-spec (s/keys :opt-un [:helloworld.HelloReply/message ]))
(def HelloReply-defaults {:message "" })

(defn cis->HelloReply
  "CodedInputStream to HelloReply"
  [is]
  (->> (tag-map HelloReply-defaults
         (fn [tag index]
             (case index
               1 [:message (serdes.core/cis->String is)]

               [index (serdes.core/cis->undefined tag is)]))
         is)
        (map->HelloReply-record)))

(defn ecis->HelloReply
  "Embedded CodedInputStream to HelloReply"
  [is]
  (serdes.core/cis->embedded cis->HelloReply is))

(defn new-HelloReply
  "Creates a new instance from a map, similar to map->HelloReply except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::HelloReply-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::HelloReply-spec init))))]}
  (-> (merge HelloReply-defaults init)
      (map->HelloReply-record)))

(defn pb->HelloReply
  "Protobuf to HelloReply"
  [input]
  (cis->HelloReply (serdes.stream/new-cis input)))

(def ^:protojure.protobuf.any/record HelloReply-meta {:type "helloworld.HelloReply" :decoder pb->HelloReply})
