package variables;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class ImageProcessing {
        public static void main(String[] args) {
            // The provided images are apple.jpg, flower.jpg, and kitten.jpg
            int[][] imageData = imgToTwoD("assets/flower.jpg");
            // Or load your own image using a URL!
            //int[][] imageData = imgToTwoD("https://content.codecademy.com/projects/project_thumbnails/phaser/bug-dodger.png");
            //viewImageData(imageData);
            //int[][] trimmed = trimBorders(imageData, 60);
            //twoDToImage(trimmed, "./trimmed_apple.jpg");
            // int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
            // Painting with pixels
            //int[][] inverted = negativeColor(imageData);
            //twoDToImage(inverted, "./myInvertedImage.jpg");
            //int[][] stretched = stretchHorizontally(imageData);
            //twoDToImage(stretched, "./myStretchedImage.jpg");

            //int[][] shrinked = shrinkVertically(imageData);
            //twoDToImage(shrinked, "./myShrinkedImage.jpg");

            //int[][] inverted = invertImage(imageData);
            //twoDToImage(inverted, "./myInvertedImage.jpg");

            int[][] filtered = colorFilter(imageData, 20, -50, 14);
            twoDToImage(filtered, "./myFilteredImage.jpg");


        }
        // Image Processing Methods
        public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
            // Example Method
            if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
                int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
                for (int i = 0; i < trimmedImg.length; i++) {
                    for (int j = 0; j < trimmedImg[i].length; j++) {
                        trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
                    }
                }
                return trimmedImg;
            } else {
                System.out.println("Cannot trim that many pixels from the given image.");
                return imageTwoD;
            }
        }
        public static int[][] negativeColor(int[][] imageTwoD) {
            // TODO: Fill in the code for this method
            for(int i=0; i <imageTwoD.length; i++){
                for(int j=0; j<imageTwoD[i].length; j++){
                    //imageTwoD[i][j] = 255 - imageTwoD[i][j];
                    int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
                    rgba[0] = 255 - rgba[0];
                    rgba[1] = 255 - rgba[1];
                    rgba[2] = 255 - rgba[2];
                    imageTwoD[i][j] = getColorIntValFromRGBA(rgba);

                }
            }
            System.out.println("Image was successfully inverted.");
            return imageTwoD;
        }
        public static int[][] stretchHorizontally(int[][] imageTwoD) {
            int[][] modifiedImage = new int[imageTwoD.length][imageTwoD[0].length * 2];

            for(int row=0; row<imageTwoD.length; row++){
                int columnIndex = 0;
                for(int column=0; column<imageTwoD[row].length;column++){
                    columnIndex = column*2;
                    modifiedImage[row][columnIndex+1] = imageTwoD[row][column];
                    modifiedImage[row][columnIndex] = imageTwoD[row][column];
                }
            }
            // TODO: Fill in the code for this method
            System.out.println("Image was successfully stretched.");
            return modifiedImage;
        }
        public static int[][] shrinkVertically(int[][] imageTwoD) {
            int[][] manipulatedImg = new int[imageTwoD.length / 2][imageTwoD[0].length];

            for(int rowIndex=0; rowIndex<imageTwoD[0].length; rowIndex++){
                for(int colIndex=0; colIndex<imageTwoD.length-1; colIndex+=2){
                    manipulatedImg[colIndex/2][rowIndex] = imageTwoD[colIndex][rowIndex];
                }
            }
            // TODO: Fill in the code for this method
            System.out.println("Image was successfully shrinked.");
            return manipulatedImg;
        }
        public static int[][] invertImage(int[][] imageTwoD) {
            int[][] invertedImg = new int[imageTwoD.length][imageTwoD[0].length];
            for(int i=0;i<imageTwoD.length;i++){
                for(int j=0; j<imageTwoD[0].length;j++){
                    invertedImg[i][j] = imageTwoD[imageTwoD.length - 1 - i][imageTwoD[i].length - 1 - j];
                }
            }
            System.out.println("Image was successfully inverted.");
            // TODO: Fill in the code for this method
            return invertedImg;
        }
        public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
            // TODO: Fill in the code for this method
            int[][] filteredImg = new int[imageTwoD.length][imageTwoD[0].length];
            for(int i=0; i <imageTwoD.length; i++){
                for(int j=0; j < imageTwoD[i].length; j++){
                    int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
                    rgba[0] += redChangeValue;
                    rgba[1] += greenChangeValue;
                    rgba[2] += blueChangeValue;
                    for(int k=0; k < rgba.length; k++){
                        if(rgba[k] < 0){
                            rgba[k] = 0;
                        }
                        else if(rgba[k] > 255){
                            rgba[k] = 255;
                        }
                    }
                    filteredImg[i][j] = getColorIntValFromRGBA(rgba);

                }
            }
            System.out.println("Image was successfully filtered.");
            return filteredImg;
        }
        // Painting Methods
        public static int[][] paintRandomImage(int[][] canvas) {
            // TODO: Fill in the code for this method
            return null;
        }
        public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int color) {
            // TODO: Fill in the code for this method
            return null;
        }
        public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
            // TODO: Fill in the code for this method
            return null;
        }
        // Utility Methods
        public static int[][] imgToTwoD(String inputFileOrLink) {
            try {
                BufferedImage image = null;
                if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
                    URL imageUrl = new URL(inputFileOrLink);
                    image = ImageIO.read(imageUrl);
                    if (image == null) {
                        System.out.println("Failed to get image from provided URL.");
                    }
                } else {
                    System.out.println("image? " + inputFileOrLink);
                    File imgFile = new File(inputFileOrLink);
                    System.out.println("yes!");
                    image = ImageIO.read(imgFile);
                    System.out.println("perfect image!");
                }
                int imgRows = image.getHeight();
                int imgCols = image.getWidth();
                int[][] pixelData = new int[imgRows][imgCols];
                for (int i = 0; i < imgRows; i++) {
                    for (int j = 0; j < imgCols; j++) {
                        pixelData[i][j] = image.getRGB(j, i);
                    }
                }
                return pixelData;
            } catch (Exception e) {
                System.out.println("Failed to load image: " + e.getLocalizedMessage());
                return null;
            }
        }
        public static void twoDToImage(int[][] imgData, String fileName) {
            try {
                int imgRows = imgData.length;
                int imgCols = imgData[0].length;
                BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
                for (int i = 0; i < imgRows; i++) {
                    for (int j = 0; j < imgCols; j++) {
                        result.setRGB(j, i, imgData[i][j]);
                    }
                }
                File output = new File(fileName);
                ImageIO.write(result, "jpg", output);
            } catch (Exception e) {
                System.out.println("Failed to save image: " + e.getLocalizedMessage());
            }
        }
        public static int[] getRGBAFromPixel(int pixelColorValue) {
            Color pixelColor = new Color(pixelColorValue);
            return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
        }
        public static int getColorIntValFromRGBA(int[] colorData) {
            if (colorData.length == 4) {
                Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
                return color.getRGB();
            } else {
                System.out.println("Incorrect number of elements in RGBA array.");
                return -1;
            }
        }
        public static void viewImageData(int[][] imageTwoD) {
            if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
                int[][] rawPixels = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        rawPixels[i][j] = imageTwoD[i][j];
                    }
                }
                System.out.println("Raw pixel data from the top left corner.");
                System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
                int[][][] rgbPixels = new int[3][3][4];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
                    }
                }
                System.out.println();
                System.out.println("Extracted RGBA pixel data from top the left corner.");
                for (int[][] row : rgbPixels) {
                    System.out.print(Arrays.deepToString(row) + System.lineSeparator());
                }
            } else {
                System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
            }
        }
    }