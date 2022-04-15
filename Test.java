public class Test {
    public static void main(String[] args) {
        ICycleLinkedList<Integer> input = new CycleLinkedList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.addAtIndex(2, 18);

        for(int i = 0; i<input.size(); i++)
        {
            System.out.println(input.get(i));
        }
        System.out.println("Test na get-a");
        System.out.println(input.get(-8));
    }
}
