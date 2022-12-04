//Single line
println new File("/uploads/input.txt").getText().split("\r\n").collect{it.split(",").collect{it.split("-").collect{it.toInteger()}}.collect{(it.get(0)..it.get(1)).toList()}}.collect{it.get(0).containsAll(it.get(1)) || it.get(1).containsAll(it.get(0)) ? 1 : 0}.sum()

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
                        it.get(0).containsAll(it.get(1)) || it.get(1).containsAll(it.get(0)) ? 1 : 0
                }.sum()