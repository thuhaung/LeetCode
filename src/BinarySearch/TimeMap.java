package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
    public class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Data>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, x -> new ArrayList<>());
        this.map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (this.map.get(key) == null) return "";
        return search(key, timestamp);
    }

    public String search(String key, int timestamp) {
        List<Data> list = this.map.get(key);

        int start = 0;
        int end = list.size() - 1;

        // 10 20
        while (start <= end) {
            int mid = start + (end - start) / 2;

            Data data = list.get(mid);

            if (data.timestamp > timestamp) {
                end = mid - 1;
            }
            else if (data.timestamp < timestamp) {
                if (mid < list.size() - 1 && list.get(mid + 1).timestamp > timestamp) {
                    return data.value;
                }
                else if (mid == list.size() - 1) break;

                start = mid + 1;
            }
            else {
                return data.value;
            }
        }

        return list.get(start).timestamp <= timestamp ? list.get(start).value : "";
    }
}
