# Distributed Cache Design

## Overview
This system implements a distributed cache with:
- Multiple cache nodes
- Pluggable distribution strategy
- Pluggable eviction policy (LRU for now)
- Read-through caching (DB fallback on miss)

---

## UML Class Diagram

```mermaid
classDiagram

class DistributedCache {
    - List~CacheNode~ nodes
    - DistributionStrategy strategy
    - Database db
    + get(key)
    + put(key, value)
}

class CacheNode {
    - int capacity
    - Map cache
    - EvictionPolicy policy
    + get(key)
    + put(key, value)
}

class DistributionStrategy {
    <<interface>>
    + getNode(key, nodes)
}

class ModuloBasedStrategy {
    + getNode(key, nodes)
}

class EvictionPolicy {
    <<interface>>
    + keyAccessed(key)
    + evictKey()
}

class LRUCachePolicy {
    - LinkedHashSet order
    + keyAccessed(key)
    + evictKey()
}

class Database {
    <<interface>>
    + get(key)
    + put(key, value)
}

class InMemoryDatabase {
    - Map store
    + get(key)
    + put(key, value)
}

DistributedCache --> CacheNode
DistributedCache --> DistributionStrategy
DistributedCache --> Database

CacheNode --> EvictionPolicy

DistributionStrategy <|-- ModuloBasedStrategy
EvictionPolicy <|-- LRUCachePolicy
Database <|-- InMemoryDatabase