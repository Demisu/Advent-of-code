//Single line
println new File("input.txt").getText().split("\r\n\r\n").collect{it.split("\r\n").collect{it.toInteger()}.sum()}.sort().takeRight(3).sum()

//Beautified
println new File("input.txt").getText()
                .split("\r\n\r\n")
                .collect{
                    it.split("\r\n").collect{
                        it.toInteger()
                    }.sum()
                }.sort().takeRight(3).sum()