//package gh2;
//import edu.princeton.cs.algs4.StdAudio;
//import edu.princeton.cs.algs4.StdDraw;
//
///**
// * A client that uses the synthesizer package to replicate a plucked guitar string sound
// */
//public class GuitarHero {
//    String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
//
//
//    public static void main(String[] args) {
//        /* create two guitar strings, for concert A and C */
//        GuitarString[] key = new GuitarString[37];
//        for(int i=0;i<37;i++){
//            key[i] = new GuitarString(440*Math.pow(2,(double)i -24)/12));
//        }
//        while (true) {
//
//            /* check if the user has typed a key; if so, process it */
//            if (StdDraw.hasNextKeyTyped()) {
//                char key = StdDraw.nextKeyTyped();
//                if (key == 'a') {
//                    stringA.pluck();
//                } else if (key == 'c') {
//                    stringC.pluck();
//                }
//            }
//
//            /* compute the superposition of samples */
//            double sample = stringA.sample() + stringC.sample();
//
//            /* play the sample on standard audio */
//            StdAudio.play(sample);
//
//            /* advance the simulation of each guitar string by one step */
//
//        }
//    }
//}
//
