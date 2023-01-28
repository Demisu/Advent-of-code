def decodeSNAFU(numberArray) {
    BigDecimal decodedNumber = new BigDecimal(0)
    BigDecimal multiplier = new BigDecimal(numberArray.size()-1)
    for(int i = 0; i < numberArray.size(); i++, multiplier--){
        def currentValue = 0
        if(numberArray[i] == '-'){
            currentValue = -1
        } else if(numberArray[i] == '='){
            currentValue = -2
        } else {
            currentValue = numberArray[i].toInteger()
        }
        decodedNumber += new BigDecimal(currentValue)*(multiplier**5)
    }
    return decodedNumber
}

println /*encodeSNAFU*/(
    new File("2022/Day 25/input.txt").getText().split("\r\n").collect{
        decodeSNAFU(it.split("(?!^)")).toInteger()
    }.sum()
)







def encodeSNAFU(decimalNumber) {
    BigDecimal encodedNumber = new BigDecimal(0)
    for(def multiplier = numberArray.size()-1, i = 0; i < numberArray.size(); i++, multiplier--){
        def currentValue = 0
        if(numberArray[i] == '-'){
            //println "found -"
            currentValue = -1
        } else if(numberArray[i] == '='){
            //println "found ="
            currentValue = -2
        } else {
            //println "found " + numberArray[i].toInteger()
            currentValue = numberArray[i].toInteger()
        }
        //println "added " + (currentValue*(5**multiplier))
        encodedNumber += currentValue*(5**multiplier)
    }
    //println "result " + encodedNumber
    return encodedNumber
}