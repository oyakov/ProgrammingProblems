public class FlowerBed {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int numFlowersAdd = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(canPlaceFlower(flowerbed, i)) {
                numFlowersAdd += 1;
                flowerbed[i] = 1;
            }
        }
        return numFlowersAdd >= n;
    }

    private static boolean canPlaceFlower(int[] flowerbed, int slotIdx) {
        return hasSpace(flowerbed, slotIdx) &&
                hasSpace(flowerbed, slotIdx - 1) &&
                hasSpace(flowerbed, slotIdx + 1);
    }

    private static boolean hasSpace(int[] flowerbed, int slotIdx) {
        return slotIdx < 0 || slotIdx >= flowerbed.length || flowerbed[slotIdx] == 0;
    }

    public static void main(String[] args) {
        boolean cpf = canPlaceFlowers(new int[]{1,0,0,0,1,0,0}, 2);
    }
}
