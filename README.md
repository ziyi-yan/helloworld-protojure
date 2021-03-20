# gRPC client in Clojure

This client is created by following this tutorial https://protojure.readthedocs.io/en/latest/quick-start/#grpc-client.

```bash
protoc --clojure_out=grpc-client:. helloworld.proto
```
The output directory:
```
$ tree helloworld
helloworld
└── Greeter
    └── client.cljc
```

## Use client in REPL
```clojure
(require '[helloworld.Greeter.client :as greeter])
(require '[protojure.grpc.client.providers.http2 :as grpc.http2])
(def client @(grpc.http2/connect {:uri "http://localhost:50051"}))
@(greeter/SayHello client {:name "Clojure"})
```
