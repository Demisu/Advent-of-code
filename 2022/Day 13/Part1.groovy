println new File("2022/Day 13/input.txt").getText().split("\r\n\r\n").collect{
    it.split("\r\n").collect{
        Eval.me(it)
    }
}.withIndex().collect{
    couple, index -> (compare([] + couple[0], [] + couple[1], index) ? index+1 : 0)
}.sum()

def compare(left, right, index) {
    //println "Comparing start: " + left + " with " + right
    if(index != -1){
    println "INDEX " + (index+1)
    println "" + left + " vs " + right
    }
    
    def rightOrder = null
    if(left instanceof Collection || right instanceof Collection){
        for(int i = 0; i < Math.min(left.size(), right.size()) && rightOrder == null; i++){
            if(index != -1){println "Comparing " + left[i] + " with " + right[i]}
            if(left[i] instanceof Collection || right[i] instanceof Collection){
                // 1 of them is still a list
                rightOrder = compare([] + left[i], [] + right[i], -1)
            }else{
                // 2 Integers
                if(left[i] != right[i]){
                    if(index != -1){println "Early return 1: " + (left[i] < right[i])}
                    return (left[i] < right[i])
                }
            }
        }
        if(rightOrder == null && left.size() < right.size()){
            rightOrder = true
        }
    }else if(left != right){
        if(index != -1){println "Early return 2: " + (left < right)}
        return (left < right)
    }
    if(index != -1){println "Late return: " + rightOrder}
    return rightOrder
}