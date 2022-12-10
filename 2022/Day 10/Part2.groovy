def input = new File("input.txt").getText().split("\r\n")
def resultMap = [:]
resultMap.put(0, 1)
def crtPixels = ["#"]
def partialResult = 1

for(int i = 0, cycle = 1; i < input.size(); i++, cycle++){
    if(input[i].contains("addx")){
        resultMap.put(cycle+3, 
            resultMap.get(cycle+3) ?
            (resultMap.get(cycle+3) + input[i].replaceAll("addx ", "").toInteger()) :
            (input[i].replaceAll("addx ", "").toInteger())
        )
        if(!resultMap.get(cycle-1)){
            resultMap.put(cycle-1, 0)
        }
        if(!resultMap.get(cycle)){
            resultMap.put(cycle, 0)
        }
        partialResult = resultMap.subMap(0..(cycle+1)).values().sum()
        crtPixels << (((cycle-1)%40 >= partialResult-1 && (cycle-1)%40 <= partialResult+1) ? "#" : ".")
        cycle++
    }
    if(!resultMap.get(cycle-1)){
        resultMap.put(cycle-1, 0)
    }
    if(!resultMap.get(cycle)){
        resultMap.put(cycle, 0)
    }
    partialResult = resultMap.subMap(0..(cycle+1)).values().sum()
    crtPixels << (((cycle-1)%40 >= partialResult-1 && (cycle-1)%40 <= partialResult+1) ? "#" : ".")
}

for(int i = 0; i < crtPixels.size(); i++){
    if((i-1) % 40 == 0){
        print "\n"+crtPixels[i]
    } else {
        print crtPixels[i]
    }
}