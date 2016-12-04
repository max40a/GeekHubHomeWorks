package task2;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectionUtils {

    private CollectionUtils() {
    }

    public static <E> List<E> filter(List<E> elements, Predicate<E> filter) {
        List<E> filteredList = new ArrayList<>();
        for (E element : elements) {
            if (filter.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

    public static <E> boolean anyMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (predicate.test(element)) {
                return true;
            }
        }
        return false;
    }

    public static <E> boolean allMatch(List<E> elements, Predicate<E> predicate) {
        for (E element : elements) {
            if (!predicate.test(element)) {
                return false;
            }
        }
        return true;
    }

    public static <E> boolean noneMatch(List<E> elements, Predicate<E> predicate) {
        return !allMatch(elements, predicate);
    }

    public static <T, R> List<R> map(List<T> elements, Function<T, R> mappingFunction) {
        List<R> mappedList = new ArrayList<>();
        for (T element : elements) {
            mappedList.add(mappingFunction.apply(element));
        }
        return mappedList;
    }

    public static <E> Optional<E> max(List<E> elements, Comparator<E> comparator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        }

        E maxElement = elements.get(0);
        for (E element : elements) {
            if (comparator.compare(element, maxElement) > 0) {
                maxElement = element;
            }
        }
        return Optional.of(maxElement);
    }

    public static <E> Optional<E> min(List<E> elements, Comparator<E> comparator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        }

        return max(elements, comparator.reversed());
    }

    public static <E> List<E> distinct(List<E> elements) {
        List<E> distinctList = new ArrayList<>();
        Set<E> hashSet = new HashSet<>();

        for (E element : elements) {
            if (hashSet.add(element)) {
                distinctList.add(element);
            }
        }

        return distinctList;
    }

    public static <E> void forEach(List<E> elements, Consumer<E> consumer) {
        for (E element : elements) {
            consumer.accept(element);
        }
    }

    public static <E> Optional<E> reduce(List<E> elements, BinaryOperator<E> accumulator) {
        if (elements.isEmpty()) {
            return Optional.empty();
        }

        E returnedValue = elements.get(0);
        for (E element : elements) {
            returnedValue = accumulator.apply(returnedValue, element);
        }
        return Optional.of(returnedValue);
    }

    public static <E> E reduce(E seed, List<E> elements, BinaryOperator<E> accumulator) {
        E result = seed;

        for (E element : elements) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    public static <E> Map<Boolean, List<E>> partitionBy(List<E> elements, Predicate<E> predicate) {
        Map<Boolean, List<E>> returnedMap = new HashMap<>();
        List<E> trueElement = new ArrayList<>();
        List<E> falseElement = new ArrayList<>();

        for (E element : elements) {
            if (predicate.test(element)) {
                trueElement.add(element);
            } else {
                falseElement.add(element);
            }
        }

        returnedMap.put(true, trueElement);
        returnedMap.put(false, falseElement);

        return returnedMap;
    }


    public static <T, K> Map<K, List<T>> groupBy(List<T> elements, Function<T, K> classifier) {
        Map<K, List<T>> returnedMap = new HashMap<>();

        for (T element : elements) {
            List<T> sortedResult = new ArrayList<>();
            K key = classifier.apply(element);
            for (T element2 : elements) {
                if (key.equals(classifier.apply(element2))) {
                    sortedResult.add(element2);
                }
            }
            returnedMap.put(key, sortedResult);
        }
        return returnedMap;
    }

    public static <T, K, U> Map<K, U> toMap(List<T> elements,
                                            Function<T, K> keyFunction,
                                            Function<T, U> valueFunction,
                                            BinaryOperator<U> mergeFunction) {
        Map<K, U> returnedMap = new HashMap<>();

        for (T element : elements) {
            K key = keyFunction.apply(element);
            U value = valueFunction.apply(element);

            if (returnedMap.containsKey(key)) {
                returnedMap.put(key, mergeFunction.apply(returnedMap.get(key), value));
            } else {
                returnedMap.put(key, value);
            }
        }

        return returnedMap;
    }
}