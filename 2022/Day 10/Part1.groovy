def input = new File("input.txt").getText().split("\r\n")
def resultMap = [:]
resultMap.put(0, [1])

for(int i = 0, cycle = 1; i < input.size(); i++, cycle++){
    if(input[i].contains("addx")){
        resultMap.put(cycle+3, 
            resultMap.get(cycle+3) ?
            (resultMap.get(cycle+3) + input[i].replaceAll("addx ", "").toInteger()) :
            (input[i].replaceAll("addx ", "").toInteger())
        )
        cycle++
    }
    if(!resultMap.get(cycle-1)){
        resultMap.put(cycle-1, [0])
    }
    if(!resultMap.get(cycle)){
        resultMap.put(cycle, [0])
    }
}

println resultMap.subMap(0..21).values().flatten().sum() * 20 +
        resultMap.subMap(0..61).values().flatten().sum() * 60 +
        resultMap.subMap(0..101).values().flatten().sum() * 100 +
        resultMap.subMap(0..141).values().flatten().sum() * 140 +
        resultMap.subMap(0..181).values().flatten().sum() * 180 +
        resultMap.subMap(0..221).values().flatten().sum() * 220