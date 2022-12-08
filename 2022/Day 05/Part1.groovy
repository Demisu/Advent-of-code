def input = new File("input.txt").getText().split("\r\n\r\n")
def crates = input[0].split("\r\n").collect{it.replaceAll("\\[|\\]", "").split(" ").reverse()}
def moves = input[1].split("\r\n").collect{it.replaceAll("move |from |to ", "").split(" ").collect{it.toInteger()}}

moves.each{
    for(int i = 0; i < it[0]; i++){
        crates[it[2]-1] += (crates[it[1]-1].last())
        crates[it[1]-1] = ((List) crates[it[1]-1]).subList(0, crates[it[1]-1].size()-1)
    }
}

println crates.collect{it.last()}.join(',').replaceAll(',', "")