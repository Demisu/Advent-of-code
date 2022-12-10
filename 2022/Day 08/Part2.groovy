// Rows
def rows = new File("input.txt").getText().split("\r\n")
def rowsNumber = rows.size()
def row = []

// Columns
def columns = [""] * rowsNumber
def columnsNumber = columns.size()
def column = []

// Fill columns
for(rowIndex = 0; rowIndex < rowsNumber; rowIndex++){
    row = rows[rowIndex]
    for(columnIndex = 0; columnIndex < columnsNumber; columnIndex++){
        value = row.substring(columnIndex, columnIndex+1).toInteger()
        columns[columnIndex] += value
    }
}

def visible = rowsNumber * 2 + (columnsNumber - 2) * 2

int rowIndex
int columnIndex

def left = []
def right = []
def top = []
def bottom = []
def result = []

// Check visibility
for(rowIndex = 1; rowIndex < rowsNumber-1; rowIndex++){
    row = rows[rowIndex]
    for(columnIndex = 1; columnIndex < columnsNumber-1; columnIndex++){
        column = columns[columnIndex]
        value = row.substring(columnIndex, columnIndex+1).toInteger()
        
        left = row.substring(0, columnIndex).split("(?!^)").flatten().collect{it.toInteger() < value ? 1 : 0}.reverse()
        right = row.substring(columnIndex+1, columnsNumber).split("(?!^)").flatten().collect{it.toInteger() < value ? 1 : 0}
        top = column.substring(0, rowIndex).split("(?!^)").flatten().collect{it.toInteger() < value ? 1 : 0}.reverse()
        bottom = column.substring(rowIndex+1, rowsNumber).split("(?!^)").flatten().collect{it.toInteger() < value ? 1 : 0}
        
        result << (left.subList(0, (left.indexOf(0) < 0 ? left.size() : left.indexOf(0)+1)).size()) *
                (right.subList(0, (right.indexOf(0) < 0 ? right.size() : right.indexOf(0)+1)).size()) *
                (top.subList(0, (top.indexOf(0) < 0 ? top.size() : top.indexOf(0)+1)).size()) *
                (bottom.subList(0, (bottom.indexOf(0) < 0 ? bottom.size() : bottom.indexOf(0)+1)).size())
    }
}

println result.max()