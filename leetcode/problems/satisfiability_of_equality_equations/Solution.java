package problems.satisfiability_of_equality_equations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        boolean r = false;

        r= s.equationsPossible(new String[]{"a==b", "b!=a"});
        System.out.println(r);

        r = s.equationsPossible(new String[]{"b==a", "a==b"});
        System.out.println(r);

        r = s.equationsPossible(new String[]{"a==b","b!=c","c==a"});
        System.out.println(r);

        r = s.equationsPossible(new String[]{"a!=a"});
        System.out.println(r);

        r = s.equationsPossible(new String[]{"c==c", "b==d", "x!=z"});
        System.out.println(r);

    }

    public boolean equationsPossible(String[] equations) {
        boolean r = true;

        Map<Character, Integer> p = new HashMap<>();
        Map<Character, Set<Character>> ps = new HashMap<>();
        Map<Character, Set<Character>> pd = new HashMap<>();

        for (int i = 0; i < equations.length; i++) {
            String q = equations[i];
            char x = q.charAt(0);
            char y = q.charAt(3);
            char c = q.charAt(1);

            if (!p.containsKey(x)) {
                p.put(x, null);
            }
            if (!p.containsKey(y)) {
                p.put(y, null);
            }

            if (c == '=') {
                Set ns = null;

                if (ps.get(x) == null && ps.get(y) == null) {
                    ns = new HashSet<>();
                    ps.put(x, ns);
                    ps.put(y, ns);
                } else if (ps.get(x) != null && ps.get(y) != null) {
                    ns = ps.get(y);
                    ns.addAll(ps.get(x));
                    for (Character cx : ps.get(x)) {
                        ps.replace(cx, ns);
                    }
                } else if (ps.get(x) == null) {
                    ns = ps.get(y);
                    ps.put(x, ns);
                } else if (ps.get(y) == null) {
                    ns = ps.get(x);
                    ps.put(y, ns);
                }

                ns.add(x);
                ns.add(y);

                if (pd.get(x) != null && pd.get(x).contains(y)) return false;
                if (pd.get(y) != null && pd.get(y).contains(x)) return false;
                if (pd.get(x) == null && pd.get(y) == null) {
                    ns = new HashSet();
                    pd.put(x, ns);
                    pd.put(y, ns);
                } else {
                    ns = new HashSet();
                    if (pd.get(x) != null) ns.addAll(pd.get(x));
                    if (pd.get(y) != null) ns.addAll(pd.get(y));
                    for (Character cx : ps.get(x)) {
                        pd.put(cx, ns);
                    }
                    for (Character cy : ps.get(y)) {
                        pd.put(cy, ns);
                    }
                }
            }

            if (c != '=') {
                Set ns = null;

                if (x == y) return false;

                if (pd.get(x) == null) {
                    pd.put(x, new HashSet<>());
                }
                if (pd.get(y) == null) {
                    pd.put(y, new HashSet<>());
                }

                pd.get(x).add(y);
                pd.get(y).add(x);

                if (ps.get(x) != null && ps.get(x).contains(y)) return false;
                if (ps.get(y) != null && ps.get(y).contains(x)) return false;
            }
        }

        return r;
    }
}
