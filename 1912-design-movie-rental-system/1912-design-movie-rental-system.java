class MovieRentingSystem {

    private Map<Integer, Map<Integer, Integer>> price;
    private Map<Integer, TreeSet<Integer>> available;
    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        price = new HashMap<>();
        available = new HashMap<>();

        for (int[] entry : entries){
            int shop = entry[0];
            int movie = entry[1];
            int p = entry[2];

            price.putIfAbsent(shop, new HashMap<>());
            price.get(shop).put(movie, p);

            available.putIfAbsent(movie,new TreeSet<>((a, b) -> {
                int priceA = price.get(a).get(movie);
                int priceB = price.get(b).get(movie);
                if (priceA != priceB) {
                    return Integer.compare(priceA, priceB);
                }
                return Integer.compare(a, b);
            }));
            available.get(movie).add(shop);
        }
        rented = new TreeSet<>((a, b) -> {

            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[2], b[2]);
        });
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();

        if (!available.containsKey(movie)){
            return result;
        }
        TreeSet<Integer> shops = available.get(movie);
        int count = 0;
        for (int shop : shops){
            result.add(shop);
            count++;

            if (count == 5){
                break;
            }
        }
        return result;
    }

    public void rent(int shop, int movie) {
        available.get(movie).remove(shop);
        int p = price.get(shop).get(movie);
        rented.add(new int[]{p, shop, movie});
    }

    public void drop(int shop, int movie) {
        int p = price.get(shop).get(movie);
        rented.remove(new int[]{p, shop, movie});
        available.get(movie).add(shop);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;

        for (int[] item : rented){
            result.add(Arrays.asList(item[1],item[2]  ));
            count++;
            if (count == 5){
                break;
            }
        }
        return result;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */