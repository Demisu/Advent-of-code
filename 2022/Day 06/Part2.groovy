//Single line
println new File("/uploads/input.txt").getText().split("\r\n").collect{it.split(",").collect{it.split("-").collect{it.toInteger()}}.collect{(it.get(0)..it.get(1)).toList()}}.collect{it.get(0).intersect(it.get(1)) ? 1 : 0}.sum()

//Beautified
println new File("/uploads/input.txt").getText()
                .split("\r\n").collect{
                    it.split(",").collect{
                        it.split("-").collect{
                            it.toInteger()
                        }
                    }.collect{
                        (it.get(0)..it.get(1)).toList()
                    }
                }.collect{
                        it.get(0).intersect(it.get(1)) ? 1 : 0
                }.sum()

/*println new File("/uploads/input.txt").getText()*/
for (int i = 0, int found = 0, def input = new File("/uploads/input.txt").getText(); i < input.length() && found < 13; i++){
    found = (input.substring(i, i+1).split("(?!^)").flatten().intersect(input.substring(i+1, i+14-found).split("(?!^)").flatten())) ? 0 : (found+1)
}
println i+1



println new File("/uploads/input.txt").getText()
                        .split("(?!^)")
                        .flatten()
                        .collect{it.toString()}
                        .eachWithIndex{it,index->
                            println "value " + it + " at index " +index
                        }
                        .collect(
                            it.split("(?!^)".flatten().intersect
                        )



/*

for(int x = 0; x<14; x++){
    for(int j = x+1; j<14; j++){
        println "   (input.charAt(i+${x}) != input.charAt(i+${j})) &&"
    }
}
/**/