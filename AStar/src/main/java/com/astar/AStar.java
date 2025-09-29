package com.astar;

import java.awt.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//By: Brandon Beckwith
class AStar {

    // NOTE: This is the only class you need to edit.
    //Feel free to add whatever methods you need here!

    /**
     * Runs A star on the given board
     *
     * @param board The board to run A Star on
     * @param start The starting Point
     * @param end   The ending Point
     * @return The spaces in order from the start Point to the end Point
     */
    public static ArrayList<Space> findPath(Board board, Point start, Point end) {

        // Setup an ArrayList to hold the path to return to the GUI
        ArrayList<Space> path = new ArrayList<Space>();

        // A* implementation
        Space startSpace = board.getSpace(start);
        Space endSpace = board.getSpace(end);

        // The set of evaluated nodes
        Set<Space> closedSet = new HashSet<>();

        // The set of discovered nodes that have not been evaluated
        PriorityQueue<Space> openSet = new PriorityQueue<>();
        startSpace.setG(0);
        startSpace.setH(heuristic(startSpace, endSpace));
        openSet.add(startSpace);

        while (!openSet.isEmpty()) {
            Space current = openSet.poll();

            if (current.equals(endSpace)) {
                return reconstructPath(current);
            }
            closedSet.add(current);

            for (Space neighbor : board.getNeighbors(current)) {
                if (closedSet.contains(neighbor)) {
                    continue; // The neighbor has already been evaluated
                }

                int tentativeGScore = current.getG() + 1; // 1 is the distance from current to neighbor.

                //
                if (!openSet.contains(neighbor)) {
                    openSet.add(neighbor);
                } else if (tentativeGScore >= neighbor.getG()) {
                    continue; // ignore worse path
                }

                // Best
                neighbor.setPrevious(current);
                neighbor.setG(tentativeGScore);
                neighbor.setH(heuristic(neighbor, endSpace));
            }
        }
        // Only reaches this if no path was found
        return path;
    }


    /**
     * Calculates the Manhatten distance (heuristic) between two spaces.
    * @param a The first space
    * @param b The second space
    * @return The heuristic value
     */
    private static int heuristic(Space a, Space b) {
        return Math.abs(a.getX() - b.getY()) + Math.abs(a.getY() - b.getY());
    }


    /**
     * Reconstructs the path from the end space to the start space.
     * @param current The end space
     * @return The path from start to end
     */
    private static ArrayList<Space> reconstructPath(Space current) {
        ArrayList<Space> path = new ArrayList<>();
        path.add(current);
        while (current.getPrevious() != null) {
            current = current.getPrevious();
            path.add(current);
        }
        Collections.reverse(path);
        return path;
    }
}