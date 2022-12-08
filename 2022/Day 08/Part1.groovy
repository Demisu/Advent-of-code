// Rows
def rows = new File("/uploads/input.txt").getText().split("\r\n")
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

// Check visibility
for(rowIndex = 1; rowIndex < rowsNumber-1; rowIndex++){
    row = rows[rowIndex]
    for(columnIndex = 1; columnIndex < columnsNumber-1; columnIndex++){
        column = columns[columnIndex]
        value = row.substring(columnIndex, columnIndex+1).toInteger()
        
        if(
            // > all left?
            row.substring(0, columnIndex).split("(?!^)").flatten().collect{it.toInteger() >= value ? 1 : 0}.sum() == 0 ||
            // > all right?
            row.substring(columnIndex+1, columnsNumber).split("(?!^)").flatten().collect{it.toInteger() >= value ? 1 : 0}.sum() == 0 ||
            // > all above?
            column.substring(0, rowIndex).split("(?!^)").flatten().collect{it.toInteger() >= value ? 1 : 0}.sum() == 0 ||
            // > all under?
            column.substring(rowIndex+1, rowsNumber).split("(?!^)").flatten().collect{it.toInteger() >= value ? 1 : 0}.sum() == 0){
                
            visible++
        }
    }
}

println visible