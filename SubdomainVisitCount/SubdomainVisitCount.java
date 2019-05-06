import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//https://leetcode-cn.com/problems/subdomain-visit-count/
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        TreeMap<String, Integer> map = new TreeMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] split = cpdomains[i].split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            if (!map.containsKey(split[1])) {
                map.put(domain, count);
                list.add(domain);
            } else {
                map.put(domain, map.get(domain) + count);
            }
            int index;
            while ((index = domain.indexOf(".")) != -1) {
                domain = domain.substring(index + 1, domain.length());
                if (map.containsKey(domain))
                    map.put(domain, map.get(domain) + count);
                else {
                    map.put(domain, count);
                    list.add(domain);
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(map.get(list.get(i)) + " " + list.get(i));
        }

        return result;
    }
}
