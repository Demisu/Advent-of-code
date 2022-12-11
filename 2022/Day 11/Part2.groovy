def monkeys = new File("input.txt").getText().split("\r\n\r\n")
def monkeysMap = [:]
def resultMap = [:]
def divisorProduct = 1

//Money = [[items], [operation], divisibleTest, targetTrue, targetFalse]
for(int i = 0; i < monkeys.size(); i++){
    def monkeyData = monkeys[i].replaceAll("Monkey " + i + ":\r\n", "").split("\r\n").collect{it.trim()}
    def monkeyItems = monkeyData[0].replaceAll("Starting items: ", "").split(", ").collect{new BigDecimal(it)}
    def monkeyOperation = monkeyData[1].replaceAll("Operation: new = old ", "").split(" ")
    def divisibleTest = monkeyData[2].replaceAll("Test: divisible by ", "").toInteger()
    def targetTrue = monkeyData[3].replaceAll("If true: throw to monkey ", "").toInteger()
    def targetFalse = monkeyData[4].replaceAll("If false: throw to monkey ", "").toInteger()
    monkeysMap.put(i, [] << monkeyItems << monkeyOperation << divisibleTest << targetTrue << targetFalse)
    resultMap.put(i, 0)
    divisorProduct *= divisibleTest
}

for(int round = 1; round < 10001; round++){
    monkeysMap.values().eachWithIndex{it,index->
        List<BigDecimal> monkeyItems = it[0]
        def monkeyOperation = it[1]
        def divisibleTest = it[2]
        def targetTrue = it[3]
        def targetFalse = it[4]
        def iterations = monkeyItems.size()
        resultMap.put(index, resultMap.get(index) + iterations)
        
        for(int i = 0; i < iterations; i++){
            BigDecimal operationValue = (monkeyOperation[1] == "old" ? monkeyItems[0] : monkeyOperation[1].toInteger())
            def result = (monkeyOperation[0] == "+" ? (monkeyItems[0] + operationValue) : (monkeyItems[0] * operationValue))
            monkeyItems[0] = new BigDecimal((result - divisorProduct * (result / divisorProduct).intValue()).intValue())
            if(monkeyItems[0].intValue() % divisibleTest == 0){
                monkeysMap.get(targetTrue)[0] = ([] << monkeysMap.get(targetTrue)[0] << monkeyItems.pop()).flatten()
            } else {
                monkeysMap.get(targetFalse)[0] = ([] << monkeysMap.get(targetFalse)[0] << monkeyItems.pop()).flatten()
            }
        }
    }
}

println new BigDecimal(resultMap.values().sort().takeRight(2)[0]) * new BigDecimal(resultMap.values().sort().takeRight(2)[1])