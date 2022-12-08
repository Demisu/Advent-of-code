for (int i = 0, int found = 0, def input = new File("input.txt").getText(); i < input.length() && found < 13; i++){
    found = (input.substring(i, i+1).split("(?!^)").flatten().intersect(input.substring(i+1, i+14-found).split("(?!^)").flatten())) ? 0 : (found+1)
}
println i+1