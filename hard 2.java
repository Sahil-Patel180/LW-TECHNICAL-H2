import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(result, currentCombination, candidates, target, 0);
        return result;
    }

    private static void backtrack(
        List<List<Integer>> result,
        List<Integer> currentCombination,
        int[] candidates,
        int remaining,
        int start
    ) {
        if (remaining < 0) {
            return;
        } else if (remaining == 0) {
            result.add(new ArrayList<>(currentCombination));
        } else {
            for (int i = start; i < candidates.length; i++) {
                currentCombination.add(candidates[i]);
                backtrack(result, currentCombination, candidates, remaining - candidates[i], i);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(candidates, target);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}