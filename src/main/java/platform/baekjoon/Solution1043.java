package platform.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/*
1043: 거짓말
 */
public class Solution1043 {

    private static Map<Integer, Integer> parentMap = new HashMap<>();

    private static int findRoot(int item) {
        if (parentMap.get(item).equals(item)) {
            return item;
        } else {
            return findRoot(parentMap.get(item));
        }
    }

    private static void unionRoot(int parent, int child) {

        int parentRoot = findRoot(parent);
        int childRoot = findRoot(child);

        parentMap.replace(childRoot, parentRoot);

    }

    public static int solution(int numPeople, List<Integer> knowTruthPeopleList, List<List<Integer>> partyList) {

        for (int people = 1; people <= numPeople; people++) {
            parentMap.put(people, people);
        }

        for(List<Integer> party: partyList) {
            int parentPeople = party.get(0);
            for(int i = 1; i < party.size(); i++) {
                int childPeople = party.get(i);

                unionRoot(parentPeople, childPeople);

                parentPeople = childPeople;
            }
        }

        Set<Integer> avoidPeopleSet = new HashSet<>();
        for(int people: knowTruthPeopleList) {
            avoidPeopleSet.add(findRoot(people));
        }

        int counter = 0;
        for(List<Integer> party: partyList) {
            boolean canLie = true;

            for (int people: party) {
                int rootPeople = findRoot(people);
                if(avoidPeopleSet.contains(rootPeople)) {
                    canLie = false;
                    break;
                }
            }

            counter += (canLie ? 1 : 0);
        }

        return counter;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numPeople = Integer.parseInt(stringTokenizer.nextToken());
        int numParty = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int numKnowTruthPeople = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> knowTruthPeopleList = new ArrayList<>(numKnowTruthPeople);
        while (stringTokenizer.hasMoreTokens()) {
            knowTruthPeopleList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        List<List<Integer>> partyList = new ArrayList<>(numParty);
        for (int i = 0; i < numParty; i++) {

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int numPartySize = Integer.parseInt(stringTokenizer.nextToken());
            List<Integer> party = new ArrayList<>(numPartySize);

            while (stringTokenizer.hasMoreTokens()) {
                party.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            partyList.add(party);
        }

        bufferedReader.close();

        int answer = solution(numPeople, knowTruthPeopleList, partyList);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.close();
    }

}
