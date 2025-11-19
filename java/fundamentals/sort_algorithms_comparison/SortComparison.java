package fundamentals.sort_algorithms_comparison;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortComparison extends Application {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private static final int[] DATA_SIZES = {
            100, 10_000, 50_000, 100_000, 500_000, 800_000, 1_000_000
    };
    // sorting algorithms
    public static void countingSort(int[] a) {
        if (a.length == 0) return;
        int max = a[0];
        for (int x : a) {
            if (x > max) max = x;
        }
        int n = a.length;
        int[] count = new int[max + 1];
        int[] output = new int[n];
        for (int x : a) {
            count[x]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[a[i]] - 1] = a[i];
            count[a[i]]--;
        }
        System.arraycopy(output, 0, a, 0, n);
    }
    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
    }
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) a[j + 1] = a[j--];
            a[j + 1] = key;
        }
    }
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (a[j] < a[min_idx])
                    min_idx = j;
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }
    public static void mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
    }
    private static void mergeSort(int[] a, int[] tmp, int l, int r) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSort(a, tmp, l, m);
        mergeSort(a, tmp, m + 1, r);
        merge(a, tmp, l, m, r);
    }
    private static void merge(int[] a, int[] tmp, int l, int m, int r) {
        System.arraycopy(a, l, tmp, l, r - l + 1);
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) a[k++] = (tmp[i] <= tmp[j]) ? tmp[i++] : tmp[j++];
        while (i <= m) a[k++] = tmp[i++];
    }
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }
    public static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int p = partition(a, lo, hi);
            quickSort(a, lo, p - 1);
            quickSort(a, p + 1, hi);
        }
    }
    private static int partition(int[] a, int lo, int hi) {
        int pivot = a[hi], i = lo - 1;
        for (int j = lo; j < hi; j++)
            if (a[j] < pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        int t = a[i + 1];
        a[i + 1] = a[hi];
        a[hi] = t;
        return i + 1;
    }
    public static void heapSort(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp; // move current root to end
            heapify(a, i, 0); // call max heapify on the reduced heap
        }
    }
    private static void heapify(int[] a, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && a[l] > a[largest]) largest = l;
        if (r < n && a[r] > a[largest]) largest = r;
        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;
            heapify(a, n, largest);
        }
    }
    public static void bucketSort(int[] a) {
        if (a.length == 0) return;
        int maxVal = a[0];
        for (int x : a) {
            if (x > maxVal) maxVal = x;
        }
        int numBuckets = (int) Math.sqrt(a.length);
        if (numBuckets == 0) numBuckets = 1;
        List<Integer>[] buckets = new List[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int x : a) {
            int bucketIndex = (int) ((double) x / maxVal * (numBuckets - 1));
            buckets[bucketIndex].add(x);
        }
        int k = 0; // index for the original array 'a'
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int x : bucket) {
                a[k++] = x;
            }
        }
    }
    public static void pancakeSort(int[] a) {
        int n = a.length;
        for (int curr_size = n; curr_size > 1; curr_size--) {
            int max_index = findMax(a, curr_size);
            if (max_index != curr_size - 1) {
                flip(a, max_index);
                flip(a, curr_size - 1);
            }
        }
    }
    // Reverses array segment a[0...k]
    private static void flip(int[] a, int k) {
        int start = 0;
        while (start < k) {
            int temp = a[start];
            a[start] = a[k];
            a[k] = temp;
            start++;
            k--;
        }
    }
    // Finds the index of the maximum element in a[0...n-1]
    private static int findMax(int[] a, int n) {
        int max_val = a[0];
        int max_index = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > max_val) {
                max_val = a[i];
                max_index = i;
            }
        }
        return max_index;
    }
    // Node class for the Binary Search Tree
    private static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    public static void treeSort(int[] a) {
        if (a.length == 0) return;
        Node root = null;
        for (int x : a) {
            root = insert(root, x);
        }
        int[] index = {0}; // Use an array wrapper to pass index by reference
        inorderRec(root, a, index);
    }
    private static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }
    private static void inorderRec(Node root, int[] a, int[] index) {
        if (root != null) {
            inorderRec(root.left, a, index);
            a[index[0]++] = root.key;
            inorderRec(root.right, a, index);
        }
    }

    // BENCHMARK
    private static long measure(Runnable r) {
        long s = System.nanoTime();
        r.run();
        return (System.nanoTime() - s) / 1_000_000; // ms
    }

    // BENCHMARK (MODIFIED FOR PARALLEL EXECUTION)
private static Map<String, List<Long>> benchmarkAll(List<String> algos) {
    // 1. Initialize the map to store results (still need LinkedHashMap for order)
    Map<String, List<Long>> allResults = new LinkedHashMap<>();
    for (String algo : algos) {
        // Initialize an empty list of results for each algorithm
        allResults.put(algo, Collections.synchronizedList(new ArrayList<>()));
    }

    // 2. Use parallel stream to run tests for different DATA_SIZES concurrently
    IntStream.of(DATA_SIZES)
            .parallel() // This enables concurrent execution across cores
            .forEach(size -> {
                // Use a fixed seed for random data to ensure all algorithms sort the EXACT same array
                Random rnd = new Random(0xCAFEBABE);
                int[] base = rnd.ints(size, 0, 100_000_000).toArray();

                // 3. Sequential execution for a single data size
                for (String name : algos) {
                    int[] arr = base.clone(); // Clone to ensure the input is unsorted for each run
                    long t;
                    switch (name) {+
                        case "Merge Sort": t = measure(() -> mergeSort(arr)); break;
                        case "Quick Sort": t = measure(() -> quickSort(arr)); break;
                        case "Bucket Sort": t = measure(() -> bucketSort(arr)); break;
                        case "Pancake Sort": t = measure(() -> pancakeSort(arr)); break;
                        case "Counting Sort": t = measure(() -> countingSort(arr)); break;
                        case "Heap Sort": t = measure(() -> heapSort(arr)); break;
                        case "Tree Sort": t = measure(() -> treeSort(arr)); break;
                        default: t = 0L; break;
                    }
                    // Add the result safely to the synchronized list
                    allResults.get(name).add(t);
                }
            });

    // NOTE: Because of the parallel execution and adding results out of order,
    // we must sort the result lists by data size to ensure the order is correct.
    // We achieve this by collecting the results into a temporary map where the key is the size,
    // then sorting by size, and finally reordering the final allResults map.

    // 4. Re-order the results since parallel stream doesn't guarantee execution order
    Map<Integer, Map<String, Long>> orderedResults = new TreeMap<>();
    for (int i = 0; i < DATA_SIZES.length; i++) {
        Map<String, Long> sizeMap = new HashMap<>();
        for (String algoName : algos) {
            sizeMap.put(algoName, allResults.get(algoName).get(i));
        }
        orderedResults.put(DATA_SIZES[i], sizeMap);
    }

    // 5. Final re-assembly into the desired format (Map<String, List<Long>>)
    Map<String, List<Long>> finalOrderedResults = new LinkedHashMap<>();
    for (String algoName : algos) {
        List<Long> times = new ArrayList<>();
        for (Map.Entry<Integer, Map<String, Long>> entry : orderedResults.entrySet()) {
            times.add(entry.getValue().get(algoName));
        }
        finalOrderedResults.put(algoName, times);
    }

    return finalOrderedResults;
}
    // UI implementation
    public void start(Stage stage) {
        stage.setTitle("Sorting Algorithm Performance Comparison");

        // UI Components
        CheckBox cbInsert = new CheckBox("Insertion Sort");
        CheckBox cbBubble = new CheckBox("Bubble Sort");
        CheckBox cbSelect = new CheckBox("Selection Sort");
        CheckBox cbMerge = new CheckBox("Merge Sort");
        CheckBox cbQuick = new CheckBox("Quick Sort");
        CheckBox cbBucket = new CheckBox("Bucket Sort");
        CheckBox cbPancake = new CheckBox("Pancake Sort");
        CheckBox cbCounting = new CheckBox("Counting Sort");
        CheckBox cbHeap = new CheckBox("Heap Sort");
        CheckBox cbTree = new CheckBox("Tree Sort");

        Button runBtn = new Button("Run Full Benchmark");
        Button saveBtn = new Button("Save Screenshot (PNG)");
        saveBtn.setDisable(true);
        ProgressIndicator prog = new ProgressIndicator(-1);
        prog.setMaxSize(18, 18);
        prog.setVisible(false);

        // Required Data Sizes for reference
        String sizes = IntStream.of(DATA_SIZES)
                .mapToObj(n -> String.format("%,d", n))
                .collect(Collectors.joining(", "));
        Label sizesLabel = new Label("Data Sizes (n): " + sizes);

        // Layouts
        HBox top = new HBox(10, runBtn, prog, new Separator(), saveBtn);
        top.setPadding(new Insets(10));
        top.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        VBox checks = new VBox(5, sizesLabel, new Separator(),
                cbInsert, cbBubble, cbSelect, cbMerge, cbQuick, cbBucket, cbPancake, cbCounting, cbHeap, cbTree);
        checks.setPadding(new Insets(10));
        checks.setStyle("-fx-border-color: #ddd; -fx-border-width: 1; -fx-border-radius: 5;");
        checks.setMaxWidth(Double.MAX_VALUE);

        // Plot the graph of time (ms) against data sizes
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        x.setLabel("Data Size (n)");
        y.setLabel("Time (ms)");

        LineChart<Number, Number> chart = new LineChart<>(x, y);
        chart.setTitle("Sorting Algorithm Performance Comparison");
        chart.setAnimated(false);
        chart.setCreateSymbols(false);

        // Tabular Data
        TableView<Map> table = new TableView<>();
        table.setPlaceholder(new Label("Click 'Run Full Benchmark' to populate the table with results."));

        // Data Size column - non-numeric to show comma-formatted value
        TableColumn<Map, String> sizeCol = new TableColumn<>("Data Size (n)");
        sizeCol.setCellValueFactory(new MapValueFactory("Data Size"));
        table.getColumns().add(sizeCol);

        SplitPane mainContent = new SplitPane(chart, table);
        mainContent.setDividerPositions(0.65);

        VBox root = new VBox(10, top, checks, mainContent);
        root.setPadding(new Insets(15));
        VBox.setVgrow(mainContent, Priority.ALWAYS);

        stage.setScene(new Scene(root, 1300, 850));
        stage.show();

        // Run Action
        runBtn.setOnAction(e -> {
            prog.setVisible(true);
            runBtn.setDisable(true);
            saveBtn.setDisable(true);
            chart.getData().clear();
            table.getColumns().remove(1, table.getColumns().size());
            table.getItems().clear();

            Task<Map<String, List<Long>>> task = new Task<>() {
                @Override
                protected Map<String, List<Long>> call() {
                    List<String> sel = new ArrayList<>();
                    if (cbInsert.isSelected()) sel.add("Insertion Sort");
                    if (cbBubble.isSelected()) sel.add("Bubble Sort");
                    if (cbSelect.isSelected()) sel.add("Selection Sort");
                    if (cbMerge.isSelected()) sel.add("Merge Sort");
                    if (cbQuick.isSelected()) sel.add("Quick Sort");
                    if (cbBucket.isSelected()) sel.add("Bucket Sort");
                    if (cbPancake.isSelected()) sel.add("Pancake Sort");
                    if (cbCounting.isSelected()) sel.add("Counting Sort");
                    if (cbHeap.isSelected()) sel.add("Heap Sort");
                    if (cbTree.isSelected()) sel.add("Tree Sort");
                    if (sel.isEmpty()) throw new IllegalStateException("Select at least one algorithm");
                    return benchmarkAll(sel);
                }
            };

            task.setOnSucceeded(ev -> Platform.runLater(() -> {
                Map<String, List<Long>> results = task.getValue();

                // Populate Chart and Table Columns
                for (String algoName : results.keySet()) {
                    // Chart Series
                    XYChart.Series<Number, Number> series = new XYChart.Series<>();
                    series.setName(algoName);
                    List<Long> times = results.get(algoName);
                    for (int i = 0; i < DATA_SIZES.length; i++) {
                        series.getData().add(new XYChart.Data<>(DATA_SIZES[i], times.get(i)));
                    }
                    chart.getData().add(series);

                    // Table Column
                    TableColumn<Map, Long> algoCol = new TableColumn<>(algoName + " (ms)");
                    algoCol.setCellValueFactory(new MapValueFactory(algoName));
                    table.getColumns().add(algoCol);
                }

                // Populate Table Rows
                List<Map> tableData = new ArrayList<>();
                for (int i = 0; i < DATA_SIZES.length; i++) {
                    Map<String, Object> row = new HashMap<>();
                    row.put("Data Size", String.format("%,d", DATA_SIZES[i]));
                    for (String algoName : results.keySet()) {
                        row.put(algoName, results.get(algoName).get(i));
                    }
                    tableData.add(row);
                }
                table.setItems(javafx.collections.FXCollections.observableArrayList(tableData));

                prog.setVisible(false);
                runBtn.setDisable(false);
                saveBtn.setDisable(false);
            }));

            task.setOnFailed(ev -> Platform.runLater(() -> {
                new Alert(Alert.AlertType.ERROR,
                        "Error: " + task.getException().getMessage()).show();
                prog.setVisible(false);
                runBtn.setDisable(false);
            }));

            executor.submit(task);
        });

        // Save Action
        saveBtn.setOnAction(e -> {
            WritableImage img = stage.getScene().snapshot(null);
            FileChooser fc = new FileChooser();
            fc.setTitle("Save chart and table as PNG");
            fc.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("PNG Image", "*.png"));
            fc.setInitialFileName("sort_benchmark_full.png");
            File file = fc.showSaveDialog(stage);
            if (file == null) return;
            new Thread(() -> {
                try {
                    ImageIO.write(SwingFXUtils.fromFXImage(img, null), "png", file);
                    Platform.runLater(() ->
                            new Alert(Alert.AlertType.INFORMATION, "Saved to\n" + file.getAbsolutePath()).show());
                } catch (IOException ex) {
                    Platform.runLater(() ->
                            new Alert(Alert.AlertType.ERROR, "Failed to write PNG:\n" + ex.getMessage()).show());
                }
            }).start();
        });
    }

    @Override
    public void stop() {
        executor.shutdownNow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}