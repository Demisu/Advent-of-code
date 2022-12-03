//Single line
println new File("/input.txt").getText().replaceAll("X|A", "0").replaceAll("Y|B", "1").replaceAll("Z|C", "2").split("\r\n").collect{it.split(" ").collect{it.toInteger()}}.collect{it.get(1) + 1 + [2, 0, 1, 2, 0].get(it.get(1) - it.get(0) + 2) * 3}.sum()

//Beautified
println new File("/input.txt").getText()
                .replaceAll("X|A", "0")
                .replaceAll("Y|B", "1")
                .replaceAll("Z|C", "2")
                .split("\r\n").collect{
                    it.split(" ").collect{
                        it.toInteger()
                    }
                }.collect{
                    it.get(1) + 1 + [2, 0, 1, 2, 0].get(it.get(1) - it.get(0) + 2) * 3
                }.sum()