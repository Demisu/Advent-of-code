//Single line
println new File("input.txt").getText().split("\r\n\r\n").collect{it.split("\r\n").collect{it.toInteger()}.sum()}.sort().last()

//Beautified
println new File("input.txt").getText()
                .split("\r\n\r\n")
                .collect{
                    it.split("\r\n").collect{
                        it.toInteger()
                    }.sum()
                }.sort().last()