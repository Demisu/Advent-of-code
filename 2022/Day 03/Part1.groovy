//Single line
println new File("input.txt").getText().split("\r\n").collect{it.substring(0, (int)(it.size()/2)).split("(?!^)").flatten().intersect(it.substring((int)(it.size()/2)).split("(?!^)").flatten()).get(0).collect{Character.isUpperCase((char)it) ? ((int)it - (int)"A" + 27) : ((int)it - (int)"a" + 1)}}.flatten().sum()

//Beautified
println new File("input.txt").getText()
                .split("\r\n").collect{
                    it.substring(0, (int)(it.size()/2))
                    .split("(?!^)")
                    .flatten()
                    .intersect(
                        it.substring((int)(it.size()/2))
                        .split("(?!^)")
                        .flatten()
                    ).get(0).collect{
                        Character.isUpperCase((char)it) ? ((int)it - (int)"A" + 27) : ((int)it - (int)"a" + 1)
                    }
                }.flatten().sum()