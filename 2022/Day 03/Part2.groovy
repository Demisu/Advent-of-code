//Single line
println new File("input.txt").getText().split("\r\n").collate(3).collect{it.get(0).split("(?!^)").flatten().intersect(it.get(1).split("(?!^)").flatten()).intersect(it.get(2).split("(?!^)").flatten()).get(0)}.collect{Character.isUpperCase((char)it) ? ((int)it - (int)"A" + 27) : ((int)it - (int)"a" + 1)}.sum()

//Beautified
println new File("input.txt").getText()
                .split("\r\n")
                .collate(3).collect{
                    it.get(0)
                    .split("(?!^)")
                    .flatten()
                    .intersect(
                        it.get(1)
                        .split("(?!^)")
                        .flatten()
                    ).intersect(
                        it.get(2)
                        .split("(?!^)")
                        .flatten()
                    ).get(0)
                }.collect{
                    Character.isUpperCase((char)it) ? ((int)it - (int)"A" + 27) : ((int)it - (int)"a" + 1)
                }.sum()