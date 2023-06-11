# OrderBook
---
## Background:
Imagine that you are in a market which only trades one type of item (e.g., tomatoes of equal quality; generally known as "shares").

There will be a certain amount of tomatoes (shares) being offered at certain prices. Also, there will be people willing to buy at a certain price.

Imagine that everyone who could buy/sell at an acceptable price (limit price) immediately does that and leaves the market.

This way (most of the time), nobody can perform a trade right now and everyone has to wait until something changes (e.g., someone reconsiders the "acceptable" price or a new person appears).

Those "limit orders" (people willing to buy/sell in certain quantities) are the limit order book.

In some cases, people are willing to buy/sell at any price (that's called a "market order"). Such a person is always going to perform the trade and then leaves the market.

In other words, each price level (for simplicity, let's think of it as an integer value) can be either bid (there are people willing to buy at this price), ask (people are willing to sell at this price), or spread (nobody is willing to buy or sell at this price).

Generally, the order book looks like the following example (B - bid, S - spread, A - ask). The size defines how many shares can be bought/sold at this price:

## Build:
To build and compile the project, follow these steps:
- Open a terminal and navigate to the root directory of the project:`cd TestTaskProxyBand`
- Run the following command to build the JAR file: `mvn clean package`
- Then start the program with the following command: `java -jar <your-project>.jar`

## Pre-requisites:
Before building and running the program, make sure 
you have the following technologies installed on your Linux based operating system:
- Java 11
- Maven 3.2

---
## Terminology:
- Ask price - The "Ask" refers to the price level at which sellers are willing to sell their shares. 
It represents the minimum price at which someone is willing to part with their shares.

- Bid price - On the other hand, the "Bid" represents the price level at which buyers are willing to buy shares. 
It represents the maximum price that a buyer is willing to pay for the shares.

## Type of operations:
| Name   | Key |
|--------|-----|
| Update | u   |
| Order  | o   |
| Query  | q   |

## Commands of the operations:
- **BEST_BID** - print best bid price and size.

- **BEST_ASK** - print best ask price and size.

- **SIZE** - print size at specified price (bid, ask or spread).

- **BUY** - removes size shares out of asks, most cheap ones.

- **SELL** - removes size shares out of bids, most expensive ones.

### Examples:
- **u,\<price>\,\<size>\,bid** - set bid size at \<price> to \<size>.

- **u,\<price>\,\<size>\,ask** - set ask size at \<price> to \<size>.

- **q,best_bid** - print best bid price and size.

- **q,best_ask** - print best ask price and size.

- **q,size,\<price>** - print size at specified price (bid, ask or spread).

- **o,buy,\<size>** - removes \<size> shares out of asks, most cheap ones.

- **o,sell,\<size>** - removes \<size> shares out of bids, most expensive ones.

## Examples of input file:
```
  u,9,1,bid
  u,11,5,ask
  q,best_bid
  u,10,2,bid
  q,best_bid
  o,sell,1
  q,size,10
  u,9,0,bid
  u,11,0,ask
```
## Examples of output file:
```
  9,1
  10,2
  1
```
