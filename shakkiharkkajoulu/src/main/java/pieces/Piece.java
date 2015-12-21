/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import main.Block;
import main.Move;

public abstract class Piece {

    abstract boolean isValidMove(Move move, Block where, Block to);
}
