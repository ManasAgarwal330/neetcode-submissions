class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet<Character>> row = new HashMap<>();
        HashMap<Integer,HashSet<Character>> col = new HashMap<>();
        HashMap<Integer,HashSet<Character>> grid = new HashMap<>();
        int prevRowGrid = -1;
        int prevColGrid = -1;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == '.')continue;

                if(row.containsKey(i)){
                    if(row.get(i).contains(board[i][j])){
                        // System.out.println(board[i][j] + " " + i);
                        return false;
                    }
                    else row.get(i).add(board[i][j]);
                }else{
                    HashSet<Character> s = new HashSet<>();
                    s.add(board[i][j]);
                    row.put(i,s);
                }

                if(col.containsKey(j)){
                    if(col.get(j).contains(board[i][j]))return false;
                    else col.get(j).add(board[i][j]);
                }else{
                    HashSet<Character> s = new HashSet<>();
                    s.add(board[i][j]);
                    col.put(j,s);
                }

                int rowGrid = i/3;
                int colGrid = j/3;

                if(prevRowGrid == -1){
                    prevRowGrid = rowGrid;
                    prevColGrid = colGrid;
                }else if(prevRowGrid != rowGrid){
                    grid = new HashMap<>();
                    prevRowGrid = rowGrid;
                    prevColGrid = colGrid;
                }
                int comb = rowGrid+colGrid;
                if(grid.containsKey(comb)){
                    if(grid.get(comb).contains(board[i][j]))return false;
                    else grid.get(comb).add(board[i][j]);
                }else{
                    HashSet<Character> s = new HashSet<>();
                    s.add(board[i][j]);
                    grid.put(comb,s);
                }

            }
        }

        return true;
    }
}
