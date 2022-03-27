package ss.test.pocketknife;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StrengthStandardsFragment extends Fragment {

    private static final Map<Integer, Integer> mWeightMen = getWeightMen();
    private static final Map<Integer, Integer> mWeightWomen = getWeightWomen();

    private static final Integer[] mListMenKG = mWeightMen.values().toArray(new Integer[mWeightMen.keySet().size()]);
    private static final Integer[] mListWomenKG = mWeightWomen.values().toArray(new Integer[mWeightWomen.values().size()]);
    private static final Integer[] mListMenLB = mWeightMen.keySet().toArray(new Integer[mWeightMen.keySet().size()]);
    private static final Integer[] mListWomenLB = mWeightWomen.keySet().toArray(new Integer[mWeightWomen.keySet().size()]);

    private static final HashMap<Integer, Double[]> mMilitaryPressMen = getMilitaryPressMen();
    private static final HashMap<Integer, Double[]> mBenchPressMen = getBenchPressMen();
    private static final HashMap<Integer, Double[]> mSquatMen = getSquatMen();
    private static final HashMap<Integer, Double[]> mDeadliftMen = getDeadliftMen();
    private static final HashMap<Integer, Double[]> mPowerCleanMen = getPowerCleanMen();

    private static final HashMap<Integer, Double[]> mMilitaryPressWomen = getMilitaryPressWomen();
    private static final HashMap<Integer, Double[]> mBenchPressWomen = getBenchPressWomen();
    private static final HashMap<Integer, Double[]> mSquatWomen = getSquatWomen();
    private static final HashMap<Integer, Double[]> mDeadliftWomen = getDeadliftWomen();
    private static final HashMap<Integer, Double[]> mPowerCleanWomen = getPowerCleanWomen();

    private static boolean mGenderIsMale = true;
    private static int mWeight = 52;
    private static boolean mUnitIsKG = true;

    private Spinner mWeightSpinner;
    private ArrayAdapter<Integer> mWeightAdapter;

    private OnFragmentInteractionListener mListener;
    public StrengthStandardsFragment() {
    }

    private static HashMap<Integer, Integer> getWeightMen() {

        HashMap<Integer, Integer> weightM = new HashMap<Integer, Integer>();

        weightM.put(114, 52);
        weightM.put(116, 53);
        weightM.put(118, 54);
        weightM.put(121, 55);
        weightM.put(123, 56);
        weightM.put(125, 57);
        weightM.put(127, 58);
        weightM.put(130, 59);
        weightM.put(132, 60);
        weightM.put(134, 61);
        weightM.put(136, 62);
        weightM.put(138, 63);
        weightM.put(140, 64);
        weightM.put(144, 65);
        weightM.put(146, 66);
        weightM.put(148, 67);
        weightM.put(150, 68);
        weightM.put(152, 69);
        weightM.put(154, 70);
        weightM.put(156, 71);
        weightM.put(159, 72);
        weightM.put(161, 73);
        weightM.put(163, 74);
        weightM.put(165, 75);
        weightM.put(167, 76);
        weightM.put(169, 77);
        weightM.put(173, 78);
        weightM.put(175, 79);
        weightM.put(177, 80);
        weightM.put(179, 81);
        weightM.put(181, 82);
        weightM.put(183, 83);
        weightM.put(185, 84);
        weightM.put(187, 85);
        weightM.put(189, 86);
        weightM.put(192, 87);
        weightM.put(194, 88);
        weightM.put(196, 89);
        weightM.put(198, 90);
        weightM.put(201, 91);
        weightM.put(203, 92);
        weightM.put(205, 93);
        weightM.put(206, 94);
        weightM.put(209, 95);
        weightM.put(212, 96);
        weightM.put(214, 97);
        weightM.put(216, 98);
        weightM.put(217, 99);
        weightM.put(220, 100);
        weightM.put(223, 101);
        weightM.put(225, 102);
        weightM.put(227, 103);
        weightM.put(228, 104);
        weightM.put(231, 105);
        weightM.put(234, 106);
        weightM.put(236, 107);
        weightM.put(238, 108);
        weightM.put(239, 109);
        weightM.put(242, 110);
        weightM.put(244, 111);
        weightM.put(246, 112);
        weightM.put(248, 113);
        weightM.put(250, 114);
        weightM.put(254, 115);
        weightM.put(256, 116);
        weightM.put(258, 117);
        weightM.put(261, 118);
        weightM.put(263, 119);
        weightM.put(265, 120);
        weightM.put(267, 121);
        weightM.put(269, 122);
        weightM.put(271, 123);
        weightM.put(273, 124);
        weightM.put(275, 125);
        weightM.put(278, 126);
        weightM.put(280, 127);
        weightM.put(283, 128);
        weightM.put(285, 129);
        weightM.put(286, 130);
        weightM.put(289, 131);
        weightM.put(291, 132);
        weightM.put(294, 133);
        weightM.put(296, 134);
        weightM.put(297, 135);
        weightM.put(300, 136);
        weightM.put(302, 137);
        weightM.put(305, 138);
        weightM.put(307, 139);
        weightM.put(308, 140);
        weightM.put(311, 141);
        weightM.put(313, 142);
        weightM.put(316, 143);
        weightM.put(318, 144);
        weightM.put(319, 145);

        return weightM;
    }

    private static HashMap<Integer, Integer> getWeightWomen() {

        HashMap<Integer, Integer> weightW = new HashMap<Integer, Integer>();
        weightW.put(97, 44);
        weightW.put(99, 45);
        weightW.put(101, 46);
        weightW.put(103, 47);
        weightW.put(105, 48);
        weightW.put(107, 49);
        weightW.put(109, 50);
        weightW.put(112, 51);
        weightW.put(114, 52);
        weightW.put(116, 53);
        weightW.put(118, 54);
        weightW.put(121, 55);
        weightW.put(123, 56);
        weightW.put(125, 57);
        weightW.put(127, 58);
        weightW.put(130, 59);
        weightW.put(132, 60);
        weightW.put(134, 61);
        weightW.put(136, 62);
        weightW.put(138, 63);
        weightW.put(140, 64);
        weightW.put(144, 65);
        weightW.put(146, 66);
        weightW.put(148, 67);
        weightW.put(150, 68);
        weightW.put(152, 69);
        weightW.put(154, 70);
        weightW.put(156, 71);
        weightW.put(159, 72);
        weightW.put(161, 73);
        weightW.put(163, 74);
        weightW.put(165, 75);
        weightW.put(167, 76);
        weightW.put(169, 77);
        weightW.put(173, 78);
        weightW.put(175, 79);
        weightW.put(177, 80);
        weightW.put(179, 81);
        weightW.put(181, 82);
        weightW.put(183, 83);
        weightW.put(185, 84);
        weightW.put(187, 85);
        weightW.put(189, 86);
        weightW.put(192, 87);
        weightW.put(194, 88);
        weightW.put(196, 89);
        weightW.put(198, 90);

        return weightW;
    }

    private static HashMap<Integer, Double[]> getMilitaryPressMen() {

        HashMap<Integer, Double[]> menMP = new HashMap<Integer, Double[]>();

        menMP.put(mWeightMen.get(114), new Double[]{24.04038, 32.65862, 40.82328, 48.53434, 58.51337});
        menMP.put(mWeightMen.get(116), new Double[]{24.49397, 33.33901, 41.73046, 49.55493, 59.87414});
        menMP.put(mWeightMen.get(118), new Double[]{24.94756, 34.01940, 42.63765, 50.57551, 61.23492});
        menMP.put(mWeightMen.get(121), new Double[]{25.40115, 34.69979, 43.54483, 51.59609, 62.59570});
        menMP.put(mWeightMen.get(123), new Double[]{25.85474, 35.38018, 44.45202, 52.61667, 63.95647});
        menMP.put(mWeightMen.get(125), new Double[]{26.30834, 36.06056, 45.24580, 53.63725, 65.09045});
        menMP.put(mWeightMen.get(127), new Double[]{26.76193, 36.74095, 46.03959, 54.65784, 66.22443});
        menMP.put(mWeightMen.get(130), new Double[]{27.21552, 37.42134, 46.83337, 55.67842, 67.35841});
        menMP.put(mWeightMen.get(132), new Double[]{27.66911, 38.10173, 47.62716, 56.69900, 68.49239});
        menMP.put(mWeightMen.get(134), new Double[]{28.12270, 38.66872, 48.42095, 57.54949, 69.51297});
        menMP.put(mWeightMen.get(136), new Double[]{28.57630, 39.23571, 49.21473, 58.39997, 70.53356});
        menMP.put(mWeightMen.get(138), new Double[]{29.02989, 39.80270, 50.00852, 59.25046, 71.55414});
        menMP.put(mWeightMen.get(140), new Double[]{29.48348, 40.36969, 50.80230, 60.10094, 72.57472});
        menMP.put(mWeightMen.get(144), new Double[]{30.39066, 41.50367, 52.38988, 61.80191, 74.61588});
        menMP.put(mWeightMen.get(146), new Double[]{30.84426, 42.07066, 53.18366, 62.65240, 75.63647});
        menMP.put(mWeightMen.get(148), new Double[]{31.29785, 42.63765, 53.97745, 63.50288, 76.65705});
        menMP.put(mWeightMen.get(150), new Double[]{31.63804, 43.09124, 54.54444, 64.23997, 77.62093});
        menMP.put(mWeightMen.get(152), new Double[]{31.97824, 43.54483, 55.11143, 64.97705, 78.58481});
        menMP.put(mWeightMen.get(154), new Double[]{32.31843, 43.99842, 55.67842, 65.71414, 79.54870});
        menMP.put(mWeightMen.get(156), new Double[]{32.65862, 44.45202, 56.24541, 66.45123, 80.51258});
        menMP.put(mWeightMen.get(159), new Double[]{32.99882, 44.90561, 56.81240, 67.18832, 81.47646});
        menMP.put(mWeightMen.get(161), new Double[]{33.33901, 45.35920, 57.37939, 67.92540, 82.44035});
        menMP.put(mWeightMen.get(163), new Double[]{33.67921, 45.81279, 57.94638, 68.66249, 83.40423});
        menMP.put(mWeightMen.get(165), new Double[]{34.01940, 46.26638, 58.51337, 69.39958, 84.36811});
        menMP.put(mWeightMen.get(167), new Double[]{34.35959, 46.71998, 59.02366, 70.02327, 86.18248});
        menMP.put(mWeightMen.get(169), new Double[]{34.69979, 47.17357, 59.53395, 70.64695, 87.99685});
        menMP.put(mWeightMen.get(173), new Double[]{35.38018, 48.08075, 60.55453, 71.89433, 91.62558});
        menMP.put(mWeightMen.get(175), new Double[]{35.72037, 48.53434, 61.06482, 72.51802, 93.43995});
        menMP.put(mWeightMen.get(177), new Double[]{36.06056, 48.98794, 61.57511, 73.14171, 95.25432});
        menMP.put(mWeightMen.get(179), new Double[]{36.40076, 49.44153, 62.08541, 73.76540, 97.06869});
        menMP.put(mWeightMen.get(181), new Double[]{36.74095, 49.89512, 62.59570, 74.38909, 98.88306});
        menMP.put(mWeightMen.get(183), new Double[]{36.96775, 50.23531, 63.04929, 74.89938, 99.79024});
        menMP.put(mWeightMen.get(185), new Double[]{37.19454, 50.57551, 63.50288, 75.40967, 100.6974});
        menMP.put(mWeightMen.get(187), new Double[]{37.42134, 50.91570, 63.95647, 75.91996, 101.6046});
        menMP.put(mWeightMen.get(189), new Double[]{37.64814, 51.25590, 64.41006, 76.43025, 102.5117});
        menMP.put(mWeightMen.get(192), new Double[]{37.87493, 51.59609, 64.86366, 76.94054, 103.4189});
        menMP.put(mWeightMen.get(194), new Double[]{38.10173, 51.93628, 65.31725, 77.45083, 104.3261});
        menMP.put(mWeightMen.get(196), new Double[]{38.32852, 52.27648, 65.77084, 77.96113, 105.2333});
        menMP.put(mWeightMen.get(198), new Double[]{38.55532, 52.61667, 66.22443, 78.47142, 106.1405});
        menMP.put(mWeightMen.get(201), new Double[]{38.78212, 52.95687, 66.73472, 79.03841, 107.3312});
        menMP.put(mWeightMen.get(203), new Double[]{39.00891, 53.29706, 67.24501, 79.60540, 108.5218});
        menMP.put(mWeightMen.get(205), new Double[]{39.12231, 53.46716, 67.50016, 79.88889, 109.1172});
        menMP.put(mWeightMen.get(206), new Double[]{39.23571, 53.63725, 67.75531, 80.17239, 109.7125});
        menMP.put(mWeightMen.get(209), new Double[]{39.46250, 53.97745, 68.26560, 80.73938, 110.9032});
        menMP.put(mWeightMen.get(212), new Double[]{39.68930, 54.31764, 68.77589, 81.30637, 112.0939});
        menMP.put(mWeightMen.get(214), new Double[]{39.91610, 54.65784, 69.28618, 81.87336, 113.2846});
        menMP.put(mWeightMen.get(216), new Double[]{40.02949, 54.82793, 69.54132, 82.15685, 113.8799});
        menMP.put(mWeightMen.get(217), new Double[]{40.14289, 54.99803, 69.79647, 82.44035, 114.4752});
        menMP.put(mWeightMen.get(220), new Double[]{40.36969, 55.33822, 70.30676, 83.00734, 115.6659});
        menMP.put(mWeightMen.get(223), new Double[]{40.59648, 55.62172, 70.53356, 83.34753, 116.1762});
        menMP.put(mWeightMen.get(225), new Double[]{40.82328, 55.90521, 70.76035, 83.68772, 116.6865});
        menMP.put(mWeightMen.get(227), new Double[]{40.93668, 56.04696, 70.87375, 83.85782, 116.9416});
        menMP.put(mWeightMen.get(228), new Double[]{41.05008, 56.18871, 70.98715, 84.02792, 117.1968});
        menMP.put(mWeightMen.get(231), new Double[]{41.27687, 56.47220, 71.21394, 84.36811, 117.7071});
        menMP.put(mWeightMen.get(234), new Double[]{41.50367, 56.75570, 71.44074, 84.70831, 118.2174});
        menMP.put(mWeightMen.get(236), new Double[]{41.73046, 57.03919, 71.66754, 85.04850, 118.7277});
        menMP.put(mWeightMen.get(238), new Double[]{41.84386, 57.18094, 71.78093, 85.21860, 118.9828});
        menMP.put(mWeightMen.get(239), new Double[]{41.95726, 57.32269, 71.89433, 85.38869, 119.2380});
        menMP.put(mWeightMen.get(242), new Double[]{42.18406, 57.60618, 72.12113, 85.72889, 119.7482});
        menMP.put(mWeightMen.get(244), new Double[]{42.26910, 57.71958, 72.26288, 85.87064, 119.9750});
        menMP.put(mWeightMen.get(246), new Double[]{42.35415, 57.83298, 72.40462, 86.01238, 120.2018});
        menMP.put(mWeightMen.get(248), new Double[]{42.43920, 57.94638, 72.54637, 86.15413, 120.4286});
        menMP.put(mWeightMen.get(250), new Double[]{42.52425, 58.05978, 72.68812, 86.29588, 120.6554});
        menMP.put(mWeightMen.get(254), new Double[]{42.69435, 58.28657, 72.97161, 86.57937, 121.1090});
        menMP.put(mWeightMen.get(256), new Double[]{42.77940, 58.39997, 73.11336, 86.72112, 121.3358});
        menMP.put(mWeightMen.get(258), new Double[]{42.86444, 58.51337, 73.25511, 86.86287, 121.5626});
        menMP.put(mWeightMen.get(261), new Double[]{42.94949, 58.62677, 73.39686, 87.00462, 121.7894});
        menMP.put(mWeightMen.get(263), new Double[]{43.03454, 58.74016, 73.53860, 87.14636, 122.0162});
        menMP.put(mWeightMen.get(265), new Double[]{43.11959, 58.85356, 73.68035, 87.28811, 122.2430});
        menMP.put(mWeightMen.get(267), new Double[]{43.20464, 58.96696, 73.82210, 87.42986, 122.4698});
        menMP.put(mWeightMen.get(269), new Double[]{43.28969, 59.08036, 73.96385, 87.57161, 122.6966});
        menMP.put(mWeightMen.get(271), new Double[]{43.37474, 59.19376, 74.10559, 87.71335, 122.9234});
        menMP.put(mWeightMen.get(273), new Double[]{43.45978, 59.30715, 74.24734, 87.85510, 123.1502});
        menMP.put(mWeightMen.get(275), new Double[]{43.54483, 59.42055, 74.38909, 87.99685, 123.3770});
        menMP.put(mWeightMen.get(278), new Double[]{43.60153, 59.47725, 74.47414, 88.13860, 123.5471});
        menMP.put(mWeightMen.get(280), new Double[]{43.65823, 59.53395, 74.55919, 88.28034, 123.7172});
        menMP.put(mWeightMen.get(283), new Double[]{43.71493, 59.59065, 74.64423, 88.42209, 123.8873});
        menMP.put(mWeightMen.get(285), new Double[]{43.74328, 59.61900, 74.68676, 88.49296, 123.9723});
        menMP.put(mWeightMen.get(286), new Double[]{43.77163, 59.64735, 74.72928, 88.56384, 124.0574});
        menMP.put(mWeightMen.get(289), new Double[]{43.82833, 59.70405, 74.81433, 88.70559, 124.2275});
        menMP.put(mWeightMen.get(291), new Double[]{43.88503, 59.76075, 74.89938, 88.84733, 124.3976});
        menMP.put(mWeightMen.get(294), new Double[]{43.94173, 59.81745, 74.98443, 88.98908, 124.5677});
        menMP.put(mWeightMen.get(296), new Double[]{43.97007, 59.84579, 75.02695, 89.05995, 124.6527});
        menMP.put(mWeightMen.get(297), new Double[]{43.99842, 59.87414, 75.06948, 89.13083, 124.7378});
        menMP.put(mWeightMen.get(300), new Double[]{44.05512, 59.93084, 75.15452, 89.27258, 124.9079});
        menMP.put(mWeightMen.get(302), new Double[]{44.11182, 59.98754, 75.23957, 89.41432, 125.0779});
        menMP.put(mWeightMen.get(305), new Double[]{44.16852, 60.04424, 75.32462, 89.55607, 125.2480});
        menMP.put(mWeightMen.get(307), new Double[]{44.19687, 60.07259, 75.36715, 89.62694, 125.3331});
        menMP.put(mWeightMen.get(308), new Double[]{44.22522, 60.10094, 75.40967, 89.69782, 125.4181});
        menMP.put(mWeightMen.get(311), new Double[]{44.28192, 60.15764, 75.49472, 89.83957, 125.5882});
        menMP.put(mWeightMen.get(313), new Double[]{44.33862, 60.21434, 75.57977, 89.98131, 125.7583});
        menMP.put(mWeightMen.get(316), new Double[]{44.39532, 60.27104, 75.66482, 90.12306, 125.9284});
        menMP.put(mWeightMen.get(318), new Double[]{44.42367, 60.29939, 75.70734, 90.19393, 126.0135});
        menMP.put(mWeightMen.get(319), new Double[]{44.45202, 60.32774, 75.74986, 90.26481, 126.0985});

        return menMP;
    }

    private static HashMap<Integer, Double[]> getBenchPressMen() {

        HashMap<Integer, Double[]> menBP = new HashMap<Integer, Double[]>();

        menBP.put(mWeightMen.get(114), new Double[]{38.10173, 48.53434, 58.96696, 81.19297, 100.69742});
        menBP.put(mWeightMen.get(116), new Double[]{38.89551, 49.55493, 60.32774, 82.89394, 102.96538});
        menBP.put(mWeightMen.get(118), new Double[]{39.68930, 50.57551, 61.68851, 84.59491, 105.23334});
        menBP.put(mWeightMen.get(121), new Double[]{40.48309, 51.59609, 63.04929, 86.29588, 107.50130});
        menBP.put(mWeightMen.get(123), new Double[]{41.27687, 52.61667, 64.41006, 87.99685, 109.76926});
        menBP.put(mWeightMen.get(125), new Double[]{42.07066, 53.63725, 65.65744, 89.58442, 111.81043});
        menBP.put(mWeightMen.get(127), new Double[]{42.86444, 54.65784, 66.90482, 91.17199, 113.85159});
        menBP.put(mWeightMen.get(130), new Double[]{43.65823, 55.67842, 68.15220, 92.75956, 115.89276});
        menBP.put(mWeightMen.get(132), new Double[]{44.45202, 56.69900, 69.39958, 94.34714, 117.93392});
        menBP.put(mWeightMen.get(134), new Double[]{45.07571, 57.54949, 70.47686, 95.82131, 119.69159});
        menBP.put(mWeightMen.get(136), new Double[]{45.69939, 58.39997, 71.55414, 97.29548, 121.44926});
        menBP.put(mWeightMen.get(138), new Double[]{46.32308, 59.25046, 72.63142, 98.76966, 123.20693});
        menBP.put(mWeightMen.get(140), new Double[]{46.94677, 60.10094, 73.70870, 100.24383, 124.96460});
        menBP.put(mWeightMen.get(144), new Double[]{48.19415, 61.80191, 75.86326, 103.19218, 128.47993});
        menBP.put(mWeightMen.get(146), new Double[]{48.81784, 62.65240, 76.94054, 104.66635, 130.23760});
        menBP.put(mWeightMen.get(148), new Double[]{49.44153, 63.50288, 78.01782, 106.14053, 131.99527});
        menBP.put(mWeightMen.get(150), new Double[]{50.00852, 64.18327, 78.86831, 107.33121, 133.58284});
        menBP.put(mWeightMen.get(152), new Double[]{50.57551, 64.86366, 79.71879, 108.52189, 135.17042});
        menBP.put(mWeightMen.get(154), new Double[]{51.14250, 65.54404, 80.56928, 109.71257, 136.75799});
        menBP.put(mWeightMen.get(156), new Double[]{51.70949, 66.22443, 81.41976, 110.90324, 138.34556});
        menBP.put(mWeightMen.get(159), new Double[]{52.27648, 66.90482, 82.27025, 112.09392, 139.93313});
        menBP.put(mWeightMen.get(161), new Double[]{52.84347, 67.58521, 83.12073, 113.28460, 141.52070});
        menBP.put(mWeightMen.get(163), new Double[]{53.41046, 68.26560, 83.97122, 114.47528, 143.10828});
        menBP.put(mWeightMen.get(165), new Double[]{53.97745, 68.94598, 84.82170, 115.66596, 144.69585});
        menBP.put(mWeightMen.get(167), new Double[]{54.48774, 69.62637, 85.61549, 116.79994, 146.05662});
        menBP.put(mWeightMen.get(169), new Double[]{54.99803, 70.30676, 86.40928, 117.93392, 147.41740});
        menBP.put(mWeightMen.get(173), new Double[]{56.01861, 71.66754, 87.99685, 120.20188, 150.13895});
        menBP.put(mWeightMen.get(175), new Double[]{56.52890, 72.34792, 88.79063, 121.33586, 151.49973});
        menBP.put(mWeightMen.get(177), new Double[]{57.03919, 73.02831, 89.58442, 122.46984, 152.86050});
        menBP.put(mWeightMen.get(179), new Double[]{57.54949, 73.70870, 90.37821, 123.60382, 154.22128});
        menBP.put(mWeightMen.get(181), new Double[]{58.05978, 74.38909, 91.17199, 124.73780, 155.58206});
        menBP.put(mWeightMen.get(183), new Double[]{58.45667, 74.89938, 91.85238, 125.53159, 156.65934});
        menBP.put(mWeightMen.get(185), new Double[]{58.85356, 75.40967, 92.53277, 126.32537, 157.73662});
        menBP.put(mWeightMen.get(187), new Double[]{59.25046, 75.91996, 93.21316, 127.11916, 158.81390});
        menBP.put(mWeightMen.get(189), new Double[]{59.64735, 76.43025, 93.89354, 127.91294, 159.89118});
        menBP.put(mWeightMen.get(192), new Double[]{60.04424, 76.94054, 94.57393, 128.70673, 160.96846});
        menBP.put(mWeightMen.get(194), new Double[]{60.44113, 77.45083, 95.25432, 129.50052, 162.04574});
        menBP.put(mWeightMen.get(196), new Double[]{60.83803, 77.96113, 95.93471, 130.29430, 163.12302});
        menBP.put(mWeightMen.get(198), new Double[]{61.23492, 78.47142, 96.61510, 131.08809, 164.20030});
        menBP.put(mWeightMen.get(201), new Double[]{61.63181, 79.03841, 97.29548, 132.05197, 165.27759});
        menBP.put(mWeightMen.get(203), new Double[]{62.02871, 79.60540, 97.97587, 133.01585, 166.35487});
        menBP.put(mWeightMen.get(205), new Double[]{62.22715, 79.88889, 98.31607, 133.49780, 166.89351});
        menBP.put(mWeightMen.get(206), new Double[]{62.42560, 80.17239, 98.65626, 133.97974, 167.43215});
        menBP.put(mWeightMen.get(209), new Double[]{62.82249, 80.73938, 99.33665, 134.94362, 168.50943});
        menBP.put(mWeightMen.get(212), new Double[]{63.21939, 81.30637, 100.01704, 135.90750, 169.58671});
        menBP.put(mWeightMen.get(214), new Double[]{63.61628, 81.87336, 100.69742, 136.87139, 170.66399});
        menBP.put(mWeightMen.get(216), new Double[]{63.81472, 82.15685, 101.03762, 137.35333, 171.20263});
        menBP.put(mWeightMen.get(217), new Double[]{64.01317, 82.44035, 101.37781, 137.83527, 171.74127});
        menBP.put(mWeightMen.get(220), new Double[]{64.41006, 83.00734, 102.05820, 138.79915, 172.81855});
        menBP.put(mWeightMen.get(223), new Double[]{64.80696, 83.40423, 102.45509, 139.36614, 173.61234});
        menBP.put(mWeightMen.get(225), new Double[]{65.20385, 83.80112, 102.85199, 139.93313, 174.40612});
        menBP.put(mWeightMen.get(227), new Double[]{65.40230, 83.99957, 103.05043, 140.21663, 174.80302});
        menBP.put(mWeightMen.get(228), new Double[]{65.60074, 84.19802, 103.24888, 140.50012, 175.19991});
        menBP.put(mWeightMen.get(231), new Double[]{65.99764, 84.59491, 103.64577, 141.06711, 175.99370});
        menBP.put(mWeightMen.get(234), new Double[]{66.39453, 84.99180, 104.04267, 141.63410, 176.78748});
        menBP.put(mWeightMen.get(236), new Double[]{66.79142, 85.38869, 104.43956, 142.20109, 177.58127});
        menBP.put(mWeightMen.get(238), new Double[]{66.98987, 85.58714, 104.63800, 142.48459, 177.97816});
        menBP.put(mWeightMen.get(239), new Double[]{67.18832, 85.78559, 104.83645, 142.76808, 178.37505});
        menBP.put(mWeightMen.get(242), new Double[]{67.58521, 86.18248, 105.23334, 143.33507, 179.16884});
        menBP.put(mWeightMen.get(244), new Double[]{67.69861, 86.35258, 105.43179, 143.59022, 179.50903});
        menBP.put(mWeightMen.get(246), new Double[]{67.81200, 86.52267, 105.63024, 143.84536, 179.84923});
        menBP.put(mWeightMen.get(248), new Double[]{67.92540, 86.69277, 105.82868, 144.10051, 180.18942});
        menBP.put(mWeightMen.get(250), new Double[]{68.03880, 86.86287, 106.02713, 144.35565, 180.52962});
        menBP.put(mWeightMen.get(254), new Double[]{68.26560, 87.20306, 106.42402, 144.86595, 181.21000});
        menBP.put(mWeightMen.get(256), new Double[]{68.37899, 87.37316, 106.62247, 145.12109, 181.55020});
        menBP.put(mWeightMen.get(258), new Double[]{68.49239, 87.54326, 106.82092, 145.37624, 181.89039});
        menBP.put(mWeightMen.get(261), new Double[]{68.60579, 87.71335, 107.01936, 145.63138, 182.23059});
        menBP.put(mWeightMen.get(263), new Double[]{68.71919, 87.88345, 107.21781, 145.88653, 182.57078});
        menBP.put(mWeightMen.get(265), new Double[]{68.83259, 88.05355, 107.41626, 146.14167, 182.91097});
        menBP.put(mWeightMen.get(267), new Double[]{68.94598, 88.22364, 107.61470, 146.39682, 183.25117});
        menBP.put(mWeightMen.get(269), new Double[]{69.05938, 88.39374, 107.81315, 146.65196, 183.59136});
        menBP.put(mWeightMen.get(271), new Double[]{69.17278, 88.56384, 108.01160, 146.90711, 183.93156});
        menBP.put(mWeightMen.get(273), new Double[]{69.28618, 88.73394, 108.21004, 147.16225, 184.27175});
        menBP.put(mWeightMen.get(275), new Double[]{69.39958, 88.90403, 108.40849, 147.41740, 184.61194});
        menBP.put(mWeightMen.get(278), new Double[]{69.48462, 88.98908, 108.55024, 147.64420, 184.86709});
        menBP.put(mWeightMen.get(280), new Double[]{69.56967, 89.07413, 108.69198, 147.87099, 185.12224});
        menBP.put(mWeightMen.get(283), new Double[]{69.65472, 89.15918, 108.83373, 148.09779, 185.37738});
        menBP.put(mWeightMen.get(285), new Double[]{69.69725, 89.20170, 108.90460, 148.21119, 185.50495});
        menBP.put(mWeightMen.get(286), new Double[]{69.73977, 89.24423, 108.97548, 148.32458, 185.63253});
        menBP.put(mWeightMen.get(289), new Double[]{69.82482, 89.32927, 109.11723, 148.55138, 185.88767});
        menBP.put(mWeightMen.get(291), new Double[]{69.90987, 89.41432, 109.25897, 148.77818, 186.14282});
        menBP.put(mWeightMen.get(294), new Double[]{69.99492, 89.49937, 109.40072, 149.00497, 186.39796});
        menBP.put(mWeightMen.get(296), new Double[]{70.03744, 89.54190, 109.47159, 149.11837, 186.52554});
        menBP.put(mWeightMen.get(297), new Double[]{70.07996, 89.58442, 109.54247, 149.23177, 186.65311});
        menBP.put(mWeightMen.get(300), new Double[]{70.16501, 89.66947, 109.68422, 149.45856, 186.90825});
        menBP.put(mWeightMen.get(302), new Double[]{70.25006, 89.75452, 109.82596, 149.68536, 187.16340});
        menBP.put(mWeightMen.get(305), new Double[]{70.33511, 89.83957, 109.96771, 149.91216, 187.41854});
        menBP.put(mWeightMen.get(307), new Double[]{70.37763, 89.88209, 110.03858, 150.02555, 187.54612});
        menBP.put(mWeightMen.get(308), new Double[]{70.42016, 89.92461, 110.10946, 150.13895, 187.67369});
        menBP.put(mWeightMen.get(311), new Double[]{70.50521, 90.00966, 110.25121, 150.36575, 187.92884});
        menBP.put(mWeightMen.get(313), new Double[]{70.59026, 90.09471, 110.39295, 150.59254, 188.18398});
        menBP.put(mWeightMen.get(316), new Double[]{70.67530, 90.17976, 110.53470, 150.81934, 188.43913});
        menBP.put(mWeightMen.get(318), new Double[]{70.71783, 90.22228, 110.60557, 150.93274, 188.56670});
        menBP.put(mWeightMen.get(319), new Double[]{70.76035, 90.26481, 110.67645, 151.04614, 188.69427});

        return menBP;
    }

    private static HashMap<Integer, Double[]> getSquatMen() {

        HashMap<Integer, Double[]> menSQ = new HashMap<Integer, Double[]>();

        menSQ.put(mWeightMen.get(114), new Double[]{35.38018, 65.31725, 78.92501, 108.86208, 145.14944});
        menSQ.put(mWeightMen.get(116), new Double[]{36.06056, 66.56463, 80.73938, 111.01664, 148.09779});
        menSQ.put(mWeightMen.get(118), new Double[]{36.74095, 67.81200, 82.55374, 113.17120, 151.04614});
        menSQ.put(mWeightMen.get(121), new Double[]{37.42134, 69.05938, 84.36811, 115.32577, 153.99448});
        menSQ.put(mWeightMen.get(123), new Double[]{38.10173, 70.30676, 86.18248, 117.48033, 156.94283});
        menSQ.put(mWeightMen.get(125), new Double[]{38.89551, 71.78093, 87.88345, 119.63489, 159.55099});
        menSQ.put(mWeightMen.get(127), new Double[]{39.68930, 73.25511, 89.58442, 121.78945, 162.15914});
        menSQ.put(mWeightMen.get(130), new Double[]{40.48309, 74.72928, 91.28539, 123.94401, 164.76729});
        menSQ.put(mWeightMen.get(132), new Double[]{41.27687, 76.20346, 92.98636, 126.09858, 167.37545});
        menSQ.put(mWeightMen.get(134), new Double[]{41.84386, 77.33744, 94.40384, 128.08304, 169.70011});
        menSQ.put(mWeightMen.get(136), new Double[]{42.41085, 78.47142, 95.82131, 130.06751, 172.02477});
        menSQ.put(mWeightMen.get(138), new Double[]{42.97784, 79.60540, 97.23879, 132.05197, 174.34943});
        menSQ.put(mWeightMen.get(140), new Double[]{43.54483, 80.73938, 98.65626, 134.03644, 176.67408});
        menSQ.put(mWeightMen.get(144), new Double[]{44.67881, 83.00734, 101.49121, 138.00537, 181.32340});
        menSQ.put(mWeightMen.get(146), new Double[]{45.24580, 84.14132, 102.90869, 139.98983, 183.64806});
        menSQ.put(mWeightMen.get(148), new Double[]{45.81279, 85.27530, 104.32616, 141.97430, 185.97272});
        menSQ.put(mWeightMen.get(150), new Double[]{46.32308, 86.18248, 105.46014, 143.61857, 187.95719});
        menSQ.put(mWeightMen.get(152), new Double[]{46.83337, 87.08966, 106.59412, 145.26284, 189.94165});
        menSQ.put(mWeightMen.get(154), new Double[]{47.34367, 87.99685, 107.72810, 146.90711, 191.92612});
        menSQ.put(mWeightMen.get(156), new Double[]{47.85396, 88.90403, 108.86208, 148.55138, 193.91058});
        menSQ.put(mWeightMen.get(159), new Double[]{48.36425, 89.81122, 109.99606, 150.19565, 195.89505});
        menSQ.put(mWeightMen.get(161), new Double[]{48.87454, 90.71840, 111.13004, 151.83992, 197.87951});
        menSQ.put(mWeightMen.get(163), new Double[]{49.38483, 91.62558, 112.26402, 153.48419, 199.86398});
        menSQ.put(mWeightMen.get(165), new Double[]{49.89512, 92.53277, 113.39800, 155.12846, 201.84844});
        menSQ.put(mWeightMen.get(167), new Double[]{50.40541, 93.43995, 114.47528, 156.54594, 203.77621});
        menSQ.put(mWeightMen.get(169), new Double[]{50.91570, 94.34714, 115.55256, 157.96341, 205.70397});
        menSQ.put(mWeightMen.get(173), new Double[]{51.93628, 96.16150, 117.70712, 160.79836, 209.55950});
        menSQ.put(mWeightMen.get(175), new Double[]{52.44658, 97.06869, 118.78441, 162.21584, 211.48727});
        menSQ.put(mWeightMen.get(177), new Double[]{52.95687, 97.97587, 119.86169, 163.63331, 213.41504});
        menSQ.put(mWeightMen.get(179), new Double[]{53.46716, 98.88306, 120.93897, 165.05079, 215.34280});
        menSQ.put(mWeightMen.get(181), new Double[]{53.97745, 99.79024, 122.01625, 166.46826, 217.27057});
        menSQ.put(mWeightMen.get(183), new Double[]{54.31764, 100.47063, 122.92343, 167.60224, 218.68804});
        menSQ.put(mWeightMen.get(185), new Double[]{54.65784, 101.15102, 123.83062, 168.73622, 220.10552});
        menSQ.put(mWeightMen.get(187), new Double[]{54.99803, 101.83140, 124.73780, 169.87020, 221.52299});
        menSQ.put(mWeightMen.get(189), new Double[]{55.33822, 102.51179, 125.64498, 171.00418, 222.94047});
        menSQ.put(mWeightMen.get(192), new Double[]{55.67842, 103.19218, 126.55217, 172.13816, 224.35794});
        menSQ.put(mWeightMen.get(194), new Double[]{56.01861, 103.87257, 127.45935, 173.27214, 225.77542});
        menSQ.put(mWeightMen.get(196), new Double[]{56.35881, 104.55296, 128.36654, 174.40612, 227.19289});
        menSQ.put(mWeightMen.get(198), new Double[]{56.69900, 105.23334, 129.27372, 175.54010, 228.61037});
        menSQ.put(mWeightMen.get(201), new Double[]{57.09589, 105.91373, 130.18090, 176.78748, 230.19794});
        menSQ.put(mWeightMen.get(203), new Double[]{57.49279, 106.59412, 131.08809, 178.03486, 231.78551});
        menSQ.put(mWeightMen.get(205), new Double[]{57.69123, 106.93431, 131.54168, 178.65855, 232.57930});
        menSQ.put(mWeightMen.get(206), new Double[]{57.88968, 107.27451, 131.99527, 179.28224, 233.37308});
        menSQ.put(mWeightMen.get(209), new Double[]{58.28657, 107.95490, 132.90246, 180.52962, 234.96066});
        menSQ.put(mWeightMen.get(212), new Double[]{58.68347, 108.63528, 133.80964, 181.77699, 236.54823});
        menSQ.put(mWeightMen.get(214), new Double[]{59.08036, 109.31567, 134.71682, 183.02437, 238.13580});
        menSQ.put(mWeightMen.get(216), new Double[]{59.27880, 109.65587, 135.17042, 183.64806, 238.92959});
        menSQ.put(mWeightMen.get(217), new Double[]{59.47725, 109.99606, 135.62401, 184.27175, 239.72337});
        menSQ.put(mWeightMen.get(220), new Double[]{59.87414, 110.67645, 136.53119, 185.51913, 241.31094});
        menSQ.put(mWeightMen.get(223), new Double[]{60.15764, 111.30014, 137.09818, 186.31291, 242.38823});
        menSQ.put(mWeightMen.get(225), new Double[]{60.44113, 111.92383, 137.66517, 187.10670, 243.46551});
        menSQ.put(mWeightMen.get(227), new Double[]{60.58288, 112.23567, 137.94867, 187.50359, 244.00415});
        menSQ.put(mWeightMen.get(228), new Double[]{60.72463, 112.54752, 138.23216, 187.90049, 244.54279});
        menSQ.put(mWeightMen.get(231), new Double[]{61.00812, 113.17120, 138.79915, 188.69427, 245.62007});
        menSQ.put(mWeightMen.get(234), new Double[]{61.29162, 113.79489, 139.36614, 189.48806, 246.69735});
        menSQ.put(mWeightMen.get(236), new Double[]{61.57511, 114.41858, 139.93313, 190.28184, 247.77463});
        menSQ.put(mWeightMen.get(238), new Double[]{61.71686, 114.73043, 140.21663, 190.67874, 248.31327});
        menSQ.put(mWeightMen.get(239), new Double[]{61.85861, 115.04227, 140.50012, 191.07563, 248.85191});
        menSQ.put(mWeightMen.get(242), new Double[]{62.14210, 115.66596, 141.06711, 191.86942, 249.92919});
        menSQ.put(mWeightMen.get(244), new Double[]{62.25550, 115.83606, 141.29391, 192.20961, 250.38278});
        menSQ.put(mWeightMen.get(246), new Double[]{62.36890, 116.00615, 141.52070, 192.54980, 250.83638});
        menSQ.put(mWeightMen.get(248), new Double[]{62.48230, 116.17625, 141.74750, 192.89000, 251.28997});
        menSQ.put(mWeightMen.get(250), new Double[]{62.59570, 116.34635, 141.97430, 193.23019, 251.74356});
        menSQ.put(mWeightMen.get(254), new Double[]{62.82249, 116.68654, 142.42789, 193.91058, 252.65074});
        menSQ.put(mWeightMen.get(256), new Double[]{62.93589, 116.85664, 142.65468, 194.25077, 253.10434});
        menSQ.put(mWeightMen.get(258), new Double[]{63.04929, 117.02674, 142.88148, 194.59097, 253.55793});
        menSQ.put(mWeightMen.get(261), new Double[]{63.16269, 117.19683, 143.10828, 194.93116, 254.01152});
        menSQ.put(mWeightMen.get(263), new Double[]{63.27608, 117.36693, 143.33507, 195.27136, 254.46511});
        menSQ.put(mWeightMen.get(265), new Double[]{63.38948, 117.53703, 143.56187, 195.61155, 254.91870});
        menSQ.put(mWeightMen.get(267), new Double[]{63.50288, 117.70712, 143.78866, 195.95174, 255.37230});
        menSQ.put(mWeightMen.get(269), new Double[]{63.61628, 117.87722, 144.01546, 196.29194, 255.82589});
        menSQ.put(mWeightMen.get(271), new Double[]{63.72968, 118.04732, 144.24226, 196.63213, 256.27948});
        menSQ.put(mWeightMen.get(273), new Double[]{63.84307, 118.21742, 144.46905, 196.97233, 256.73307});
        menSQ.put(mWeightMen.get(275), new Double[]{63.95647, 118.38751, 144.69585, 197.31252, 257.18666});
        menSQ.put(mWeightMen.get(278), new Double[]{64.04152, 118.55761, 144.89429, 197.59602, 257.55521});
        menSQ.put(mWeightMen.get(280), new Double[]{64.12657, 118.72771, 145.09274, 197.87951, 257.92375});
        menSQ.put(mWeightMen.get(283), new Double[]{64.21162, 118.89780, 145.29119, 198.16301, 258.29229});
        menSQ.put(mWeightMen.get(285), new Double[]{64.25414, 118.98285, 145.39041, 198.30475, 258.47657});
        menSQ.put(mWeightMen.get(286), new Double[]{64.29667, 119.06790, 145.48963, 198.44650, 258.66084});
        menSQ.put(mWeightMen.get(289), new Double[]{64.38171, 119.23800, 145.68808, 198.73000, 259.02938});
        menSQ.put(mWeightMen.get(291), new Double[]{64.46676, 119.40809, 145.88653, 199.01349, 259.39793});
        menSQ.put(mWeightMen.get(294), new Double[]{64.55181, 119.57819, 146.08497, 199.29699, 259.76647});
        menSQ.put(mWeightMen.get(296), new Double[]{64.59434, 119.66324, 146.18420, 199.43873, 259.95074});
        menSQ.put(mWeightMen.get(297), new Double[]{64.63686, 119.74829, 146.28342, 199.58048, 260.13501});
        menSQ.put(mWeightMen.get(300), new Double[]{64.72191, 119.91839, 146.48187, 199.86398, 260.50356});
        menSQ.put(mWeightMen.get(302), new Double[]{64.80696, 120.08848, 146.68031, 200.14747, 260.87210});
        menSQ.put(mWeightMen.get(305), new Double[]{64.89201, 120.25858, 146.87876, 200.43097, 261.24064});
        menSQ.put(mWeightMen.get(307), new Double[]{64.93453, 120.34363, 146.97798, 200.57271, 261.42491});
        menSQ.put(mWeightMen.get(308), new Double[]{64.97705, 120.42868, 147.07721, 200.71446, 261.60919});
        menSQ.put(mWeightMen.get(311), new Double[]{65.06210, 120.59877, 147.27565, 200.99796, 261.97773});
        menSQ.put(mWeightMen.get(313), new Double[]{65.14715, 120.76887, 147.47410, 201.28145, 262.34627});
        menSQ.put(mWeightMen.get(316), new Double[]{65.23220, 120.93897, 147.67255, 201.56495, 262.71482});
        menSQ.put(mWeightMen.get(318), new Double[]{65.27472, 121.02402, 147.77177, 201.70669, 262.89909});
        menSQ.put(mWeightMen.get(319), new Double[]{65.31725, 121.10906, 147.87099, 201.84844, 263.08336});

        return menSQ;
    }

    private static HashMap<Integer, Double[]> getDeadliftMen() {

        HashMap<Integer, Double[]> menDL = new HashMap<Integer, Double[]>();

        menDL.put(mWeightMen.get(114), new Double[]{43.99842, 81.19297, 92.53277, 135.62401, 175.54010});
        menDL.put(mWeightMen.get(116), new Double[]{44.90561, 82.89394, 94.57393, 138.00537, 178.60185});
        menDL.put(mWeightMen.get(118), new Double[]{45.81279, 84.59491, 96.61510, 140.38672, 181.66360});
        menDL.put(mWeightMen.get(121), new Double[]{46.71998, 86.29588, 98.65626, 142.76808, 184.72534});
        menDL.put(mWeightMen.get(123), new Double[]{47.62716, 87.99685, 100.69742, 145.14944, 187.78709});
        menDL.put(mWeightMen.get(125), new Double[]{48.53434, 89.69782, 102.62519, 147.64420, 190.50864});
        menDL.put(mWeightMen.get(127), new Double[]{49.44153, 91.39879, 104.55296, 150.13895, 193.23019});
        menDL.put(mWeightMen.get(130), new Double[]{50.34871, 93.09976, 106.48072, 152.63371, 195.95174});
        menDL.put(mWeightMen.get(132), new Double[]{51.25590, 94.80073, 108.40849, 155.12846, 198.67330});
        menDL.put(mWeightMen.get(134), new Double[]{51.99298, 96.21820, 110.10946, 157.28303, 201.16805});
        menDL.put(mWeightMen.get(136), new Double[]{52.73007, 97.63568, 111.81043, 159.43759, 203.66281});
        menDL.put(mWeightMen.get(138), new Double[]{53.46716, 99.05315, 113.51140, 161.59215, 206.15756});
        menDL.put(mWeightMen.get(140), new Double[]{54.20424, 100.47063, 115.21237, 163.74671, 208.65232});
        menDL.put(mWeightMen.get(144), new Double[]{55.67842, 103.30558, 118.61431, 168.05584, 213.64183});
        menDL.put(mWeightMen.get(146), new Double[]{56.41551, 104.72305, 120.31528, 170.21040, 216.13659});
        menDL.put(mWeightMen.get(148), new Double[]{57.15259, 106.14053, 122.01625, 172.36496, 218.63134});
        menDL.put(mWeightMen.get(150), new Double[]{57.77628, 107.27451, 123.37702, 174.12263, 220.67251});
        menDL.put(mWeightMen.get(152), new Double[]{58.39997, 108.40849, 124.73780, 175.88030, 222.71367});
        menDL.put(mWeightMen.get(154), new Double[]{59.02366, 109.54247, 126.09858, 177.63797, 224.75484});
        menDL.put(mWeightMen.get(156), new Double[]{59.64735, 110.67645, 127.45935, 179.39564, 226.79600});
        menDL.put(mWeightMen.get(159), new Double[]{60.27104, 111.81043, 128.82013, 181.15331, 228.83716});
        menDL.put(mWeightMen.get(161), new Double[]{60.89473, 112.94441, 130.18090, 182.91097, 230.87833});
        menDL.put(mWeightMen.get(163), new Double[]{61.51842, 114.07839, 131.54168, 184.66864, 232.91949});
        menDL.put(mWeightMen.get(165), new Double[]{62.14210, 115.21237, 132.90246, 186.42631, 234.96066});
        menDL.put(mWeightMen.get(167), new Double[]{62.76579, 116.34635, 134.14983, 187.95719, 236.66163});
        menDL.put(mWeightMen.get(169), new Double[]{63.38948, 117.48033, 135.39721, 189.48806, 238.36260});
        menDL.put(mWeightMen.get(173), new Double[]{64.63686, 119.74829, 137.89197, 192.54980, 241.76454});
        menDL.put(mWeightMen.get(175), new Double[]{65.26055, 120.88227, 139.13935, 194.08068, 243.46551});
        menDL.put(mWeightMen.get(177), new Double[]{65.88424, 122.01625, 140.38672, 195.61155, 245.16648});
        menDL.put(mWeightMen.get(179), new Double[]{66.50793, 123.15023, 141.63410, 197.14242, 246.86745});
        menDL.put(mWeightMen.get(181), new Double[]{67.13162, 124.28421, 142.88148, 198.67330, 248.56842});
        menDL.put(mWeightMen.get(183), new Double[]{67.58521, 125.13469, 143.90206, 199.75058, 249.64570});
        menDL.put(mWeightMen.get(185), new Double[]{68.03880, 125.98518, 144.92264, 200.82786, 250.72298});
        menDL.put(mWeightMen.get(187), new Double[]{68.49239, 126.83566, 145.94323, 201.90514, 251.80026});
        menDL.put(mWeightMen.get(189), new Double[]{68.94598, 127.68615, 146.96381, 202.98242, 252.87754});
        menDL.put(mWeightMen.get(192), new Double[]{69.39958, 128.53663, 147.98439, 204.05970, 253.95482});
        menDL.put(mWeightMen.get(194), new Double[]{69.85317, 129.38712, 149.00497, 205.13698, 255.03210});
        menDL.put(mWeightMen.get(196), new Double[]{70.30676, 130.23760, 150.02555, 206.21426, 256.10938});
        menDL.put(mWeightMen.get(198), new Double[]{70.76035, 131.08809, 151.04614, 207.29154, 257.18666});
        menDL.put(mWeightMen.get(201), new Double[]{71.21394, 131.99527, 152.06672, 208.53892, 258.26395});
        menDL.put(mWeightMen.get(203), new Double[]{71.66754, 132.90246, 153.08730, 209.78630, 259.34123});
        menDL.put(mWeightMen.get(205), new Double[]{71.89433, 133.35605, 153.59759, 210.40999, 259.87987});
        menDL.put(mWeightMen.get(206), new Double[]{72.12113, 133.80964, 154.10788, 211.03368, 260.41851});
        menDL.put(mWeightMen.get(209), new Double[]{72.57472, 134.71682, 155.12846, 212.28106, 261.49579});
        menDL.put(mWeightMen.get(212), new Double[]{73.02831, 135.62401, 156.14905, 213.52843, 262.57307});
        menDL.put(mWeightMen.get(214), new Double[]{73.48190, 136.53119, 157.16963, 214.77581, 263.65035});
        menDL.put(mWeightMen.get(216), new Double[]{73.70870, 136.98478, 157.67992, 215.39950, 264.18899});
        menDL.put(mWeightMen.get(217), new Double[]{73.93550, 137.43838, 158.19021, 216.02319, 264.72763});
        menDL.put(mWeightMen.get(220), new Double[]{74.38909, 138.34556, 159.21079, 217.27057, 265.80491});
        menDL.put(mWeightMen.get(223), new Double[]{74.84268, 139.08265, 159.89118, 217.89426, 266.37190});
        menDL.put(mWeightMen.get(225), new Double[]{75.29627, 139.81973, 160.57157, 218.51795, 266.93889});
        menDL.put(mWeightMen.get(227), new Double[]{75.52307, 140.18828, 160.91176, 218.82979, 267.22239});
        menDL.put(mWeightMen.get(228), new Double[]{75.74986, 140.55682, 161.25196, 219.14164, 267.50588});
        menDL.put(mWeightMen.get(231), new Double[]{76.20346, 141.29391, 161.93234, 219.76532, 268.07287});
        menDL.put(mWeightMen.get(234), new Double[]{76.65705, 142.03100, 162.61273, 220.38901, 268.63986});
        menDL.put(mWeightMen.get(236), new Double[]{77.11064, 142.76808, 163.29312, 221.01270, 269.20685});
        menDL.put(mWeightMen.get(238), new Double[]{77.33744, 143.13663, 163.63331, 221.32455, 269.49035});
        menDL.put(mWeightMen.get(239), new Double[]{77.56423, 143.50517, 163.97351, 221.63639, 269.77384});
        menDL.put(mWeightMen.get(242), new Double[]{78.01782, 144.24226, 164.65390, 222.26008, 270.34083});
        menDL.put(mWeightMen.get(244), new Double[]{78.13122, 144.46905, 164.93739, 222.51523, 270.51093});
        menDL.put(mWeightMen.get(246), new Double[]{78.24462, 144.69585, 165.22089, 222.77037, 270.68103});
        menDL.put(mWeightMen.get(248), new Double[]{78.35802, 144.92264, 165.50438, 223.02552, 270.85112});
        menDL.put(mWeightMen.get(250), new Double[]{78.47142, 145.14944, 165.78788, 223.28066, 271.02122});
        menDL.put(mWeightMen.get(254), new Double[]{78.69821, 145.60303, 166.35487, 223.79095, 271.36141});
        menDL.put(mWeightMen.get(256), new Double[]{78.81161, 145.82983, 166.63836, 224.04610, 271.53151});
        menDL.put(mWeightMen.get(258), new Double[]{78.92501, 146.05662, 166.92186, 224.30124, 271.70161});
        menDL.put(mWeightMen.get(261), new Double[]{79.03841, 146.28342, 167.20535, 224.55639, 271.87171});
        menDL.put(mWeightMen.get(263), new Double[]{79.15180, 146.51022, 167.48885, 224.81154, 272.04180});
        menDL.put(mWeightMen.get(265), new Double[]{79.26520, 146.73701, 167.77234, 225.06668, 272.21190});
        menDL.put(mWeightMen.get(267), new Double[]{79.37860, 146.96381, 168.05584, 225.32183, 272.38200});
        menDL.put(mWeightMen.get(269), new Double[]{79.49200, 147.19060, 168.33933, 225.57697, 272.55209});
        menDL.put(mWeightMen.get(271), new Double[]{79.60540, 147.41740, 168.62283, 225.83212, 272.72219});
        menDL.put(mWeightMen.get(273), new Double[]{79.71879, 147.64420, 168.90632, 226.08726, 272.89229});
        menDL.put(mWeightMen.get(275), new Double[]{79.83219, 147.87099, 169.18982, 226.34241, 273.06238});
        menDL.put(mWeightMen.get(278), new Double[]{79.94559, 148.06944, 169.41661, 226.54085, 273.23248});
        menDL.put(mWeightMen.get(280), new Double[]{80.05899, 148.26789, 169.64341, 226.73930, 273.40258});
        menDL.put(mWeightMen.get(283), new Double[]{80.17239, 148.46633, 169.87020, 226.93775, 273.57268});
        menDL.put(mWeightMen.get(285), new Double[]{80.22909, 148.56555, 169.98360, 227.03697, 273.65772});
        menDL.put(mWeightMen.get(286), new Double[]{80.28578, 148.66478, 170.09700, 227.13619, 273.74277});
        menDL.put(mWeightMen.get(289), new Double[]{80.39918, 148.86322, 170.32380, 227.33464, 273.91287});
        menDL.put(mWeightMen.get(291), new Double[]{80.51258, 149.06167, 170.55059, 227.53309, 274.08297});
        menDL.put(mWeightMen.get(294), new Double[]{80.62598, 149.26012, 170.77739, 227.73153, 274.25306});
        menDL.put(mWeightMen.get(296), new Double[]{80.68268, 149.35934, 170.89079, 227.83076, 274.33811});
        menDL.put(mWeightMen.get(297), new Double[]{80.73938, 149.45856, 171.00418, 227.92998, 274.42316});
        menDL.put(mWeightMen.get(300), new Double[]{80.85277, 149.65701, 171.23098, 228.12843, 274.59326});
        menDL.put(mWeightMen.get(302), new Double[]{80.96617, 149.85546, 171.45778, 228.32687, 274.76335});
        menDL.put(mWeightMen.get(305), new Double[]{81.07957, 150.05390, 171.68457, 228.52532, 274.93345});
        menDL.put(mWeightMen.get(307), new Double[]{81.13627, 150.15313, 171.79797, 228.62454, 275.01850});
        menDL.put(mWeightMen.get(308), new Double[]{81.19297, 150.25235, 171.91137, 228.72377, 275.10355});
        menDL.put(mWeightMen.get(311), new Double[]{81.30637, 150.45080, 172.13816, 228.92221, 275.27365});
        menDL.put(mWeightMen.get(313), new Double[]{81.41976, 150.64924, 172.36496, 229.12066, 275.44374});
        menDL.put(mWeightMen.get(316), new Double[]{81.53316, 150.84769, 172.59176, 229.31911, 275.61384});
        menDL.put(mWeightMen.get(318), new Double[]{81.58986, 150.94691, 172.70515, 229.41833, 275.69889});
        menDL.put(mWeightMen.get(319), new Double[]{81.64656, 151.04614, 172.81855, 229.51755, 275.78394});

        return menDL;
    }

    private static HashMap<Integer, Double[]> getPowerCleanMen() {

        HashMap<Integer, Double[]> menPC = new HashMap<Integer, Double[]>();

        menPC.put(mWeightMen.get(114), new Double[]{25.40115, 46.71998, 56.69900, 78.47142, 93.89354});
        menPC.put(mWeightMen.get(116), new Double[]{25.85474, 47.74056, 58.05978, 79.94559, 95.82131});
        menPC.put(mWeightMen.get(118), new Double[]{26.30834, 48.76114, 59.42055, 81.41976, 97.74908});
        menPC.put(mWeightMen.get(121), new Double[]{26.76193, 49.78172, 60.78133, 82.89394, 99.67684});
        menPC.put(mWeightMen.get(123), new Double[]{27.21552, 50.80230, 62.14210, 84.36811, 101.60461});
        menPC.put(mWeightMen.get(125), new Double[]{27.78251, 51.82289, 63.38948, 85.95568, 103.30558});
        menPC.put(mWeightMen.get(127), new Double[]{28.34950, 52.84347, 64.63686, 87.54326, 105.00655});
        menPC.put(mWeightMen.get(130), new Double[]{28.91649, 53.86405, 65.88424, 89.13083, 106.70752});
        menPC.put(mWeightMen.get(132), new Double[]{29.48348, 54.88463, 67.13162, 90.71840, 108.40849});
        menPC.put(mWeightMen.get(134), new Double[]{29.93707, 55.67842, 68.15220, 92.13588, 109.93936});
        menPC.put(mWeightMen.get(136), new Double[]{30.39066, 56.47220, 69.17278, 93.55335, 111.47023});
        menPC.put(mWeightMen.get(138), new Double[]{30.84426, 57.26599, 70.19336, 94.97083, 113.00111});
        menPC.put(mWeightMen.get(140), new Double[]{31.29785, 58.05978, 71.21394, 96.38830, 114.53198});
        menPC.put(mWeightMen.get(144), new Double[]{32.20503, 59.64735, 73.25511, 99.22325, 117.59373});
        menPC.put(mWeightMen.get(146), new Double[]{32.65862, 60.44113, 74.27569, 100.64073, 119.12460});
        menPC.put(mWeightMen.get(148), new Double[]{33.11222, 61.23492, 75.29627, 102.05820, 120.65547});
        menPC.put(mWeightMen.get(150), new Double[]{33.45241, 61.91531, 76.09006, 103.24888, 121.90285});
        menPC.put(mWeightMen.get(152), new Double[]{33.79260, 62.59570, 76.88384, 104.43956, 123.15023});
        menPC.put(mWeightMen.get(154), new Double[]{34.13280, 63.27608, 77.67763, 105.63024, 124.39761});
        menPC.put(mWeightMen.get(156), new Double[]{34.47299, 63.95647, 78.47142, 106.82092, 125.64498});
        menPC.put(mWeightMen.get(159), new Double[]{34.81319, 64.63686, 79.26520, 108.01160, 126.89236});
        menPC.put(mWeightMen.get(161), new Double[]{35.15338, 65.31725, 80.05899, 109.20227, 128.13974});
        menPC.put(mWeightMen.get(163), new Double[]{35.49357, 65.99764, 80.85277, 110.39295, 129.38712});
        menPC.put(mWeightMen.get(165), new Double[]{35.83377, 66.67802, 81.64656, 111.58363, 130.63450});
        menPC.put(mWeightMen.get(167), new Double[]{36.17396, 67.30171, 82.44035, 112.60421, 131.88187});
        menPC.put(mWeightMen.get(169), new Double[]{36.51416, 67.92540, 83.23413, 113.62480, 133.12925});
        menPC.put(mWeightMen.get(173), new Double[]{37.19454, 69.17278, 84.82170, 115.66596, 135.62401});
        menPC.put(mWeightMen.get(175), new Double[]{37.53474, 69.79647, 85.61549, 116.68654, 136.87139});
        menPC.put(mWeightMen.get(177), new Double[]{37.87493, 70.42016, 86.40928, 117.70712, 138.11876});
        menPC.put(mWeightMen.get(179), new Double[]{38.21513, 71.04385, 87.20306, 118.72771, 139.36614});
        menPC.put(mWeightMen.get(181), new Double[]{38.55532, 71.66754, 87.99685, 119.74829, 140.61352});
        menPC.put(mWeightMen.get(183), new Double[]{38.83882, 72.17783, 88.62054, 120.59877, 141.57740});
        menPC.put(mWeightMen.get(185), new Double[]{39.12231, 72.68812, 89.24423, 121.44926, 142.54129});
        menPC.put(mWeightMen.get(187), new Double[]{39.40581, 73.19841, 89.86792, 122.29974, 143.50517});
        menPC.put(mWeightMen.get(189), new Double[]{39.68930, 73.70870, 90.49160, 123.15023, 144.46905});
        menPC.put(mWeightMen.get(192), new Double[]{39.97280, 74.21899, 91.11529, 124.00071, 145.43294});
        menPC.put(mWeightMen.get(194), new Double[]{40.25629, 74.72928, 91.73898, 124.85120, 146.39682});
        menPC.put(mWeightMen.get(196), new Double[]{40.53979, 75.23957, 92.36267, 125.70168, 147.36070});
        menPC.put(mWeightMen.get(198), new Double[]{40.82328, 75.74986, 92.98636, 126.55217, 148.32458});
        menPC.put(mWeightMen.get(201), new Double[]{41.10678, 76.26016, 93.66675, 127.40265, 149.34517});
        menPC.put(mWeightMen.get(203), new Double[]{41.39027, 76.77045, 94.34714, 128.25314, 150.36575});
        menPC.put(mWeightMen.get(205), new Double[]{41.53202, 77.02559, 94.68733, 128.67838, 150.87604});
        menPC.put(mWeightMen.get(206), new Double[]{41.67377, 77.28074, 95.02752, 129.10362, 151.38633});
        menPC.put(mWeightMen.get(209), new Double[]{41.95726, 77.79103, 95.70791, 129.95411, 152.40691});
        menPC.put(mWeightMen.get(212), new Double[]{42.24076, 78.30132, 96.38830, 130.80459, 153.42749});
        menPC.put(mWeightMen.get(214), new Double[]{42.52425, 78.81161, 97.06869, 131.65508, 154.44808});
        menPC.put(mWeightMen.get(216), new Double[]{42.66600, 79.06676, 97.40888, 132.08032, 154.95837});
        menPC.put(mWeightMen.get(217), new Double[]{42.80775, 79.32190, 97.74908, 132.50556, 155.46866});
        menPC.put(mWeightMen.get(220), new Double[]{43.09124, 79.83219, 98.42946, 133.35605, 156.48924});
        menPC.put(mWeightMen.get(223), new Double[]{43.31804, 80.22909, 98.82636, 133.97974, 157.16963});
        menPC.put(mWeightMen.get(225), new Double[]{43.54483, 80.62598, 99.22325, 134.60343, 157.85002});
        menPC.put(mWeightMen.get(227), new Double[]{43.65823, 80.82442, 99.42170, 134.91527, 158.19021});
        menPC.put(mWeightMen.get(228), new Double[]{43.77163, 81.02287, 99.62014, 135.22712, 158.53040});
        menPC.put(mWeightMen.get(231), new Double[]{43.99842, 81.41976, 100.01704, 135.85080, 159.21079});
        menPC.put(mWeightMen.get(234), new Double[]{44.22522, 81.81666, 100.41393, 136.47449, 159.89118});
        menPC.put(mWeightMen.get(236), new Double[]{44.45202, 82.21355, 100.81082, 137.09818, 160.57157});
        menPC.put(mWeightMen.get(238), new Double[]{44.56541, 82.41200, 101.00927, 137.41003, 160.91176});
        menPC.put(mWeightMen.get(239), new Double[]{44.67881, 82.61044, 101.20772, 137.72187, 161.25196});
        menPC.put(mWeightMen.get(242), new Double[]{44.90561, 83.00734, 101.60461, 138.34556, 161.93234});
        menPC.put(mWeightMen.get(244), new Double[]{44.99066, 83.14908, 101.77471, 138.57236, 162.21584});
        menPC.put(mWeightMen.get(246), new Double[]{45.07571, 83.29083, 101.94480, 138.79915, 162.49933});
        menPC.put(mWeightMen.get(248), new Double[]{45.16075, 83.43258, 102.11490, 139.02595, 162.78283});
        menPC.put(mWeightMen.get(250), new Double[]{45.24580, 83.57433, 102.28500, 139.25274, 163.06632});
        menPC.put(mWeightMen.get(254), new Double[]{45.41590, 83.85782, 102.62519, 139.70634, 163.63331});
        menPC.put(mWeightMen.get(256), new Double[]{45.50095, 83.99957, 102.79529, 139.93313, 163.91681});
        menPC.put(mWeightMen.get(258), new Double[]{45.58600, 84.14132, 102.96538, 140.15993, 164.20030});
        menPC.put(mWeightMen.get(261), new Double[]{45.67104, 84.28306, 103.13548, 140.38672, 164.48380});
        menPC.put(mWeightMen.get(263), new Double[]{45.75609, 84.42481, 103.30558, 140.61352, 164.76729});
        menPC.put(mWeightMen.get(265), new Double[]{45.84114, 84.56656, 103.47568, 140.84032, 165.05079});
        menPC.put(mWeightMen.get(267), new Double[]{45.92619, 84.70831, 103.64577, 141.06711, 165.33428});
        menPC.put(mWeightMen.get(269), new Double[]{46.01124, 84.85005, 103.81587, 141.29391, 165.61778});
        menPC.put(mWeightMen.get(271), new Double[]{46.09629, 84.99180, 103.98597, 141.52070, 165.90127});
        menPC.put(mWeightMen.get(273), new Double[]{46.18134, 85.13355, 104.15606, 141.74750, 166.18477});
        menPC.put(mWeightMen.get(275), new Double[]{46.26638, 85.27530, 104.32616, 141.97430, 166.46826});
        menPC.put(mWeightMen.get(278), new Double[]{46.32308, 85.38869, 104.46791, 142.17274, 166.72341});
        menPC.put(mWeightMen.get(280), new Double[]{46.37978, 85.50209, 104.60966, 142.37119, 166.97856});
        menPC.put(mWeightMen.get(283), new Double[]{46.43648, 85.61549, 104.75140, 142.56964, 167.23370});
        menPC.put(mWeightMen.get(285), new Double[]{46.46483, 85.67219, 104.82228, 142.66886, 167.36127});
        menPC.put(mWeightMen.get(286), new Double[]{46.49318, 85.72889, 104.89315, 142.76808, 167.48885});
        menPC.put(mWeightMen.get(289), new Double[]{46.54988, 85.84229, 105.03490, 142.96653, 167.74399});
        menPC.put(mWeightMen.get(291), new Double[]{46.60658, 85.95568, 105.17665, 143.16498, 167.99914});
        menPC.put(mWeightMen.get(294), new Double[]{46.66328, 86.06908, 105.31839, 143.36342, 168.25428});
        menPC.put(mWeightMen.get(296), new Double[]{46.69163, 86.12578, 105.38927, 143.46264, 168.38186});
        menPC.put(mWeightMen.get(297), new Double[]{46.71998, 86.18248, 105.46014, 143.56187, 168.50943});
        menPC.put(mWeightMen.get(300), new Double[]{46.77668, 86.29588, 105.60189, 143.76031, 168.76457});
        menPC.put(mWeightMen.get(302), new Double[]{46.83337, 86.40928, 105.74364, 143.95876, 169.01972});
        menPC.put(mWeightMen.get(305), new Double[]{46.89007, 86.52267, 105.88538, 144.15721, 169.27486});
        menPC.put(mWeightMen.get(307), new Double[]{46.91842, 86.57937, 105.95626, 144.25643, 169.40244});
        menPC.put(mWeightMen.get(308), new Double[]{46.94677, 86.63607, 106.02713, 144.35565, 169.53001});
        menPC.put(mWeightMen.get(311), new Double[]{47.00347, 86.74947, 106.16888, 144.55410, 169.78516});
        menPC.put(mWeightMen.get(313), new Double[]{47.06017, 86.86287, 106.31063, 144.75255, 170.04030});
        menPC.put(mWeightMen.get(316), new Double[]{47.11687, 86.97627, 106.45237, 144.95099, 170.29545});
        menPC.put(mWeightMen.get(318), new Double[]{47.14522, 87.03297, 106.52325, 145.05022, 170.42302});
        menPC.put(mWeightMen.get(319), new Double[]{47.17357, 87.08966, 106.59412, 145.14944, 170.55059});

        return menPC;
    }

    private static HashMap<Integer, Double[]> getMilitaryPressWomen() {

        HashMap<Integer, Double[]> womenMP = new HashMap<Integer, Double[]>();

        womenMP.put(mWeightWomen.get(97), new Double[]{14.06135, 19.05086, 22.67960, 29.93707, 38.55532});
        womenMP.put(mWeightWomen.get(99), new Double[]{14.28815, 19.50446, 23.01979, 30.50406, 39.23571});
        womenMP.put(mWeightWomen.get(101), new Double[]{14.51494, 19.95805, 23.35999, 31.07105, 39.91610});
        womenMP.put(mWeightWomen.get(103), new Double[]{14.74174, 20.41164, 23.70018, 31.63804, 40.59648});
        womenMP.put(mWeightWomen.get(105), new Double[]{14.96854, 20.86523, 24.04038, 32.20503, 41.27687});
        womenMP.put(mWeightWomen.get(107), new Double[]{15.30873, 21.20543, 24.60737, 32.77202, 41.95726});
        womenMP.put(mWeightWomen.get(109), new Double[]{15.64892, 21.54562, 25.17436, 33.33901, 42.63765});
        womenMP.put(mWeightWomen.get(112), new Double[]{15.98912, 21.88581, 25.74135, 33.90600, 43.31804});
        womenMP.put(mWeightWomen.get(114), new Double[]{16.32931, 22.22601, 26.30834, 34.47299, 43.99842});
        womenMP.put(mWeightWomen.get(116), new Double[]{16.55611, 22.56620, 26.64853, 35.03998, 44.79221});
        womenMP.put(mWeightWomen.get(118), new Double[]{16.78290, 22.90640, 26.98872, 35.60697, 45.58600});
        womenMP.put(mWeightWomen.get(121), new Double[]{17.00970, 23.24659, 27.32892, 36.17396, 46.37978});
        womenMP.put(mWeightWomen.get(123), new Double[]{17.23650, 23.58678, 27.66911, 36.74095, 47.17357});
        womenMP.put(mWeightWomen.get(125), new Double[]{17.46329, 23.92698, 28.12270, 37.19454, 47.85396});
        womenMP.put(mWeightWomen.get(127), new Double[]{17.69009, 24.26717, 28.57630, 37.64814, 48.53434});
        womenMP.put(mWeightWomen.get(130), new Double[]{17.91688, 24.60737, 29.02989, 38.10173, 49.21473});
        womenMP.put(mWeightWomen.get(132), new Double[]{18.14368, 24.94756, 29.48348, 38.55532, 49.89512});
        womenMP.put(mWeightWomen.get(134), new Double[]{18.37048, 25.23106, 29.88037, 39.06561, 50.51881});
        womenMP.put(mWeightWomen.get(136), new Double[]{18.59727, 25.51455, 30.27727, 39.57590, 51.14250});
        womenMP.put(mWeightWomen.get(138), new Double[]{18.82407, 25.79805, 30.67416, 40.08619, 51.76619});
        womenMP.put(mWeightWomen.get(140), new Double[]{19.05086, 26.08154, 31.07105, 40.59648, 52.38988});
        womenMP.put(mWeightWomen.get(144), new Double[]{19.50446, 26.64853, 31.86484, 41.61707, 53.63725});
        womenMP.put(mWeightWomen.get(146), new Double[]{19.73125, 26.93203, 32.26173, 42.12736, 54.26094});
        womenMP.put(mWeightWomen.get(148), new Double[]{19.95805, 27.21552, 32.65862, 42.63765, 54.88463});
        womenMP.put(mWeightWomen.get(150), new Double[]{20.18484, 27.49902, 32.94212, 43.09124, 55.62172});
        womenMP.put(mWeightWomen.get(152), new Double[]{20.41164, 27.78251, 33.22561, 43.54483, 56.35881});
        womenMP.put(mWeightWomen.get(154), new Double[]{20.63844, 28.06601, 33.50911, 43.99842, 57.09589});
        womenMP.put(mWeightWomen.get(156), new Double[]{20.86523, 28.34950, 33.79260, 44.45202, 57.83298});
        womenMP.put(mWeightWomen.get(159), new Double[]{21.09203, 28.63300, 34.07610, 44.90561, 58.57007});
        womenMP.put(mWeightWomen.get(161), new Double[]{21.31882, 28.91649, 34.35959, 45.35920, 59.30715});
        womenMP.put(mWeightWomen.get(163), new Double[]{21.54562, 29.19999, 34.64309, 45.81279, 60.04424});
        womenMP.put(mWeightWomen.get(165), new Double[]{21.77242, 29.48348, 34.92658, 46.26638, 60.78133});
        womenMP.put(mWeightWomen.get(167), new Double[]{21.94251, 29.76698, 35.26678, 46.71998, 61.12152});
        womenMP.put(mWeightWomen.get(169), new Double[]{22.11261, 30.05047, 35.60697, 47.17357, 61.46172});
        womenMP.put(mWeightWomen.get(173), new Double[]{22.45280, 30.61746, 36.28736, 48.08075, 62.14210});
        womenMP.put(mWeightWomen.get(175), new Double[]{22.62290, 30.90096, 36.62755, 48.53434, 62.48230});
        womenMP.put(mWeightWomen.get(177), new Double[]{22.79300, 31.18445, 36.96775, 48.98794, 62.82249});
        womenMP.put(mWeightWomen.get(179), new Double[]{22.96310, 31.46795, 37.30794, 49.44153, 63.16269});
        womenMP.put(mWeightWomen.get(181), new Double[]{23.13319, 31.75144, 37.64814, 49.89512, 63.50288});
        womenMP.put(mWeightWomen.get(183), new Double[]{23.35999, 32.03494, 37.93163, 50.29201, 64.12657});
        womenMP.put(mWeightWomen.get(185), new Double[]{23.58678, 32.31843, 38.21513, 50.68891, 64.75026});
        womenMP.put(mWeightWomen.get(187), new Double[]{23.81358, 32.60193, 38.49862, 51.08580, 65.37395});
        womenMP.put(mWeightWomen.get(189), new Double[]{24.04038, 32.88542, 38.78212, 51.48269, 65.99764});
        womenMP.put(mWeightWomen.get(192), new Double[]{24.26717, 33.16892, 39.06561, 51.87959, 66.62133});
        womenMP.put(mWeightWomen.get(194), new Double[]{24.49397, 33.45241, 39.34911, 52.27648, 67.24501});
        womenMP.put(mWeightWomen.get(196), new Double[]{24.72076, 33.73591, 39.63260, 52.67337, 67.86870});
        womenMP.put(mWeightWomen.get(198), new Double[]{24.94756, 34.01940, 39.91610, 53.07026, 68.49239});

        return womenMP;
    }

    private static HashMap<Integer, Double[]> getBenchPressWomen() {

        HashMap<Integer, Double[]> womenBP = new HashMap<Integer, Double[]>();

        womenBP.put(mWeightWomen.get(97), new Double[]{22.22601, 28.57630, 33.11222, 42.63765, 52.61667});
        womenBP.put(mWeightWomen.get(99), new Double[]{22.67960, 29.14329, 33.79260, 43.54483, 53.52386});
        womenBP.put(mWeightWomen.get(101), new Double[]{23.13319, 29.71028, 34.47299, 44.45202, 54.43104});
        womenBP.put(mWeightWomen.get(103), new Double[]{23.58678, 30.27727, 35.15338, 45.35920, 55.33822});
        womenBP.put(mWeightWomen.get(105), new Double[]{24.04038, 30.84426, 35.83377, 46.26638, 56.24541});
        womenBP.put(mWeightWomen.get(107), new Double[]{24.49397, 31.41125, 36.51416, 47.06017, 57.26599});
        womenBP.put(mWeightWomen.get(109), new Double[]{24.94756, 31.97824, 37.19454, 47.85396, 58.28657});
        womenBP.put(mWeightWomen.get(112), new Double[]{25.40115, 32.54523, 37.87493, 48.64774, 59.30715});
        womenBP.put(mWeightWomen.get(114), new Double[]{25.85474, 33.11222, 38.55532, 49.44153, 60.32774});
        womenBP.put(mWeightWomen.get(116), new Double[]{26.19494, 33.56581, 39.12231, 50.23531, 61.34832});
        womenBP.put(mWeightWomen.get(118), new Double[]{26.53513, 34.01940, 39.68930, 51.02910, 62.36890});
        womenBP.put(mWeightWomen.get(121), new Double[]{26.87533, 34.47299, 40.25629, 51.82289, 63.38948});
        womenBP.put(mWeightWomen.get(123), new Double[]{27.21552, 34.92658, 40.82328, 52.61667, 64.41006});
        womenBP.put(mWeightWomen.get(125), new Double[]{27.66911, 35.49357, 41.39027, 53.29706, 65.31725});
        womenBP.put(mWeightWomen.get(127), new Double[]{28.12270, 36.06056, 41.95726, 53.97745, 66.22443});
        womenBP.put(mWeightWomen.get(130), new Double[]{28.57630, 36.62755, 42.52425, 54.65784, 67.13162});
        womenBP.put(mWeightWomen.get(132), new Double[]{29.02989, 37.19454, 43.09124, 55.33822, 68.03880});
        womenBP.put(mWeightWomen.get(134), new Double[]{29.37008, 37.64814, 43.65823, 56.07531, 68.88929});
        womenBP.put(mWeightWomen.get(136), new Double[]{29.71028, 38.10173, 44.22522, 56.81240, 69.73977});
        womenBP.put(mWeightWomen.get(138), new Double[]{30.05047, 38.55532, 44.79221, 57.54949, 70.59026});
        womenBP.put(mWeightWomen.get(140), new Double[]{30.39066, 39.00891, 45.35920, 58.28657, 71.44074});
        womenBP.put(mWeightWomen.get(144), new Double[]{31.07105, 39.91610, 46.49318, 59.76075, 73.14171});
        womenBP.put(mWeightWomen.get(146), new Double[]{31.41125, 40.36969, 47.06017, 60.49783, 73.99220});
        womenBP.put(mWeightWomen.get(148), new Double[]{31.75144, 40.82328, 47.62716, 61.23492, 74.84268});
        womenBP.put(mWeightWomen.get(150), new Double[]{32.09163, 41.22017, 48.08075, 61.85861, 75.86326});
        womenBP.put(mWeightWomen.get(152), new Double[]{32.43183, 41.61707, 48.53434, 62.48230, 76.88384});
        womenBP.put(mWeightWomen.get(154), new Double[]{32.77202, 42.01396, 48.98794, 63.10599, 77.90443});
        womenBP.put(mWeightWomen.get(156), new Double[]{33.11222, 42.41085, 49.44153, 63.72968, 78.92501});
        womenBP.put(mWeightWomen.get(159), new Double[]{33.45241, 42.80775, 49.89512, 64.35337, 79.94559});
        womenBP.put(mWeightWomen.get(161), new Double[]{33.79260, 43.20464, 50.34871, 64.97705, 80.96617});
        womenBP.put(mWeightWomen.get(163), new Double[]{34.13280, 43.60153, 50.80230, 65.60074, 81.98675});
        womenBP.put(mWeightWomen.get(165), new Double[]{34.47299, 43.99842, 51.25590, 66.22443, 83.00734});
        womenBP.put(mWeightWomen.get(167), new Double[]{34.75649, 44.39532, 51.76619, 66.90482, 83.51763});
        womenBP.put(mWeightWomen.get(169), new Double[]{35.03998, 44.79221, 52.27648, 67.58521, 84.02792});
        womenBP.put(mWeightWomen.get(173), new Double[]{35.60697, 45.58600, 53.29706, 68.94598, 85.04850});
        womenBP.put(mWeightWomen.get(175), new Double[]{35.89047, 45.98289, 53.80735, 69.62637, 85.55879});
        womenBP.put(mWeightWomen.get(177), new Double[]{36.17396, 46.37978, 54.31764, 70.30676, 86.06908});
        womenBP.put(mWeightWomen.get(179), new Double[]{36.45746, 46.77668, 54.82793, 70.98715, 86.57937});
        womenBP.put(mWeightWomen.get(181), new Double[]{36.74095, 47.17357, 55.33822, 71.66754, 87.08966});
        womenBP.put(mWeightWomen.get(183), new Double[]{37.13785, 47.62716, 55.79182, 72.17783, 87.82675});
        womenBP.put(mWeightWomen.get(185), new Double[]{37.53474, 48.08075, 56.24541, 72.68812, 88.56384});
        womenBP.put(mWeightWomen.get(187), new Double[]{37.93163, 48.53434, 56.69900, 73.19841, 89.30093});
        womenBP.put(mWeightWomen.get(189), new Double[]{38.32852, 48.98794, 57.15259, 73.70870, 90.03801});
        womenBP.put(mWeightWomen.get(192), new Double[]{38.72542, 49.44153, 57.60618, 74.21899, 90.77510});
        womenBP.put(mWeightWomen.get(194), new Double[]{39.12231, 49.89512, 58.05978, 74.72928, 91.51219});
        womenBP.put(mWeightWomen.get(196), new Double[]{39.51920, 50.34871, 58.51337, 75.23957, 92.24927});
        womenBP.put(mWeightWomen.get(198), new Double[]{39.91610, 50.80230, 58.96696, 75.74986, 92.98636});

        return womenBP;
    }

    private static HashMap<Integer, Double[]> getSquatWomen() {

        HashMap<Integer, Double[]> womenSQ = new HashMap<Integer, Double[]>();

        womenSQ.put(mWeightWomen.get(97), new Double[]{20.86523, 38.10173, 44.45202, 58.51337, 73.93550});
        womenSQ.put(mWeightWomen.get(99), new Double[]{21.20543, 38.89551, 45.35920, 59.76075, 75.18287});
        womenSQ.put(mWeightWomen.get(101), new Double[]{21.54562, 39.68930, 46.26638, 61.00812, 76.43025});
        womenSQ.put(mWeightWomen.get(103), new Double[]{21.88581, 40.48309, 47.17357, 62.25550, 77.67763});
        womenSQ.put(mWeightWomen.get(105), new Double[]{22.22601, 41.27687, 48.08075, 63.50288, 78.92501});
        womenSQ.put(mWeightWomen.get(107), new Double[]{22.67960, 42.07066, 48.98794, 64.63686, 80.39918});
        womenSQ.put(mWeightWomen.get(109), new Double[]{23.13319, 42.86444, 49.89512, 65.77084, 81.87336});
        womenSQ.put(mWeightWomen.get(112), new Double[]{23.58678, 43.65823, 50.80230, 66.90482, 83.34753});
        womenSQ.put(mWeightWomen.get(114), new Double[]{24.04038, 44.45202, 51.70949, 68.03880, 84.82170});
        womenSQ.put(mWeightWomen.get(116), new Double[]{24.38057, 45.01901, 52.50327, 69.17278, 86.18248});
        womenSQ.put(mWeightWomen.get(118), new Double[]{24.72076, 45.58600, 53.29706, 70.30676, 87.54326});
        womenSQ.put(mWeightWomen.get(121), new Double[]{25.06096, 46.15299, 54.09085, 71.44074, 88.90403});
        womenSQ.put(mWeightWomen.get(123), new Double[]{25.40115, 46.71998, 54.88463, 72.57472, 90.26481});
        womenSQ.put(mWeightWomen.get(125), new Double[]{25.74135, 47.51376, 55.56502, 73.48190, 91.62558});
        womenSQ.put(mWeightWomen.get(127), new Double[]{26.08154, 48.30755, 56.24541, 74.38909, 92.98636});
        womenSQ.put(mWeightWomen.get(130), new Double[]{26.42173, 49.10133, 56.92580, 75.29627, 94.34714});
        womenSQ.put(mWeightWomen.get(132), new Double[]{26.76193, 49.89512, 57.60618, 76.20346, 95.70791});
        womenSQ.put(mWeightWomen.get(134), new Double[]{27.10212, 50.51881, 58.39997, 77.16734, 96.89859});
        womenSQ.put(mWeightWomen.get(136), new Double[]{27.44232, 51.14250, 59.19376, 78.13122, 98.08927});
        womenSQ.put(mWeightWomen.get(138), new Double[]{27.78251, 51.76619, 59.98754, 79.09511, 99.27995});
        womenSQ.put(mWeightWomen.get(140), new Double[]{28.12270, 52.38988, 60.78133, 80.05899, 100.47063});
        womenSQ.put(mWeightWomen.get(144), new Double[]{28.80309, 53.63725, 62.36890, 81.98675, 102.85199});
        womenSQ.put(mWeightWomen.get(146), new Double[]{29.14329, 54.26094, 63.16269, 82.95064, 104.04267});
        womenSQ.put(mWeightWomen.get(148), new Double[]{29.48348, 54.88463, 63.95647, 83.91452, 105.23334});
        womenSQ.put(mWeightWomen.get(150), new Double[]{29.76698, 55.39492, 64.52346, 84.76501, 106.59412});
        womenSQ.put(mWeightWomen.get(152), new Double[]{30.05047, 55.90521, 65.09045, 85.61549, 107.95490});
        womenSQ.put(mWeightWomen.get(154), new Double[]{30.33397, 56.41551, 65.65744, 86.46598, 109.31567});
        womenSQ.put(mWeightWomen.get(156), new Double[]{30.61746, 56.92580, 66.22443, 87.31646, 110.67645});
        womenSQ.put(mWeightWomen.get(159), new Double[]{30.90096, 57.43609, 66.79142, 88.16695, 112.03722});
        womenSQ.put(mWeightWomen.get(161), new Double[]{31.18445, 57.94638, 67.35841, 89.01743, 113.39800});
        womenSQ.put(mWeightWomen.get(163), new Double[]{31.46795, 58.45667, 67.92540, 89.86792, 114.75878});
        womenSQ.put(mWeightWomen.get(165), new Double[]{31.75144, 58.96696, 68.49239, 90.71840, 116.11955});
        womenSQ.put(mWeightWomen.get(167), new Double[]{32.03494, 59.47725, 69.22948, 91.56889, 116.79994});
        womenSQ.put(mWeightWomen.get(169), new Double[]{32.31843, 59.98754, 69.96657, 92.41937, 117.48033});
        womenSQ.put(mWeightWomen.get(173), new Double[]{32.88542, 61.00812, 71.44074, 94.12034, 118.84110});
        womenSQ.put(mWeightWomen.get(175), new Double[]{33.16892, 61.51842, 72.17783, 94.97083, 119.52149});
        womenSQ.put(mWeightWomen.get(177), new Double[]{33.45241, 62.02871, 72.91491, 95.82131, 120.20188});
        womenSQ.put(mWeightWomen.get(179), new Double[]{33.73591, 62.53900, 73.65200, 96.67180, 120.88227});
        womenSQ.put(mWeightWomen.get(181), new Double[]{34.01940, 63.04929, 74.38909, 97.52228, 121.56266});
        womenSQ.put(mWeightWomen.get(183), new Double[]{34.35959, 63.67298, 74.95608, 98.31607, 122.69664});
        womenSQ.put(mWeightWomen.get(185), new Double[]{34.69979, 64.29667, 75.52307, 99.10985, 123.83062});
        womenSQ.put(mWeightWomen.get(187), new Double[]{35.03998, 64.92036, 76.09006, 99.90364, 124.96460});
        womenSQ.put(mWeightWomen.get(189), new Double[]{35.38018, 65.54404, 76.65705, 100.69742, 126.09858});
        womenSQ.put(mWeightWomen.get(192), new Double[]{35.72037, 66.16773, 77.22404, 101.49121, 127.23256});
        womenSQ.put(mWeightWomen.get(194), new Double[]{36.06056, 66.79142, 77.79103, 102.28500, 128.36654});
        womenSQ.put(mWeightWomen.get(196), new Double[]{36.40076, 67.41511, 78.35802, 103.07878, 129.50052});
        womenSQ.put(mWeightWomen.get(198), new Double[]{36.74095, 68.03880, 78.92501, 103.87257, 130.63450});

        return womenSQ;
    }

    private static HashMap<Integer, Double[]> getDeadliftWomen() {

        HashMap<Integer, Double[]> womenDL = new HashMap<Integer, Double[]>();

        womenDL.put(mWeightWomen.get(97), new Double[]{25.85474, 47.62716, 55.33822, 79.37860, 105.23334});
        womenDL.put(mWeightWomen.get(99), new Double[]{26.30834, 48.64774, 56.47220, 80.96617, 106.36732});
        womenDL.put(mWeightWomen.get(101), new Double[]{26.76193, 49.66832, 57.60618, 82.55374, 107.50130});
        womenDL.put(mWeightWomen.get(103), new Double[]{27.21552, 50.68891, 58.74016, 84.14132, 108.63528});
        womenDL.put(mWeightWomen.get(105), new Double[]{27.66911, 51.70949, 59.87414, 85.72889, 109.76926});
        womenDL.put(mWeightWomen.get(107), new Double[]{28.23610, 52.61667, 61.00812, 86.97627, 111.01664});
        womenDL.put(mWeightWomen.get(109), new Double[]{28.80309, 53.52386, 62.14210, 88.22364, 112.26402});
        womenDL.put(mWeightWomen.get(112), new Double[]{29.37008, 54.43104, 63.27608, 89.47102, 113.51140});
        womenDL.put(mWeightWomen.get(114), new Double[]{29.93707, 55.33822, 64.41006, 90.71840, 114.75878});
        womenDL.put(mWeightWomen.get(116), new Double[]{30.39066, 56.13201, 65.43065, 91.96578, 115.89276});
        womenDL.put(mWeightWomen.get(118), new Double[]{30.84426, 56.92580, 66.45123, 93.21316, 117.02674});
        womenDL.put(mWeightWomen.get(121), new Double[]{31.29785, 57.71958, 67.47181, 94.46053, 118.16072});
        womenDL.put(mWeightWomen.get(123), new Double[]{31.75144, 58.51337, 68.49239, 95.70791, 119.29470});
        womenDL.put(mWeightWomen.get(125), new Double[]{32.20503, 59.42055, 69.39958, 96.72849, 120.42868});
        womenDL.put(mWeightWomen.get(127), new Double[]{32.65862, 60.32774, 70.30676, 97.74908, 121.56266});
        womenDL.put(mWeightWomen.get(130), new Double[]{33.11222, 61.23492, 71.21394, 98.76966, 122.69664});
        womenDL.put(mWeightWomen.get(132), new Double[]{33.56581, 62.14210, 72.12113, 99.79024, 123.83062});
        womenDL.put(mWeightWomen.get(134), new Double[]{33.96270, 62.93589, 73.08501, 100.98092, 125.07799});
        womenDL.put(mWeightWomen.get(136), new Double[]{34.35959, 63.72968, 74.04889, 102.17160, 126.32537});
        womenDL.put(mWeightWomen.get(138), new Double[]{34.75649, 64.52346, 75.01278, 103.36228, 127.57275});
        womenDL.put(mWeightWomen.get(140), new Double[]{35.15338, 65.31725, 75.97666, 104.55296, 128.82013});
        womenDL.put(mWeightWomen.get(144), new Double[]{35.94717, 66.90482, 77.90443, 106.93431, 131.31488});
        womenDL.put(mWeightWomen.get(146), new Double[]{36.34406, 67.69861, 78.86831, 108.12499, 132.56226});
        womenDL.put(mWeightWomen.get(148), new Double[]{36.74095, 68.49239, 79.83219, 109.31567, 133.80964});
        womenDL.put(mWeightWomen.get(150), new Double[]{37.13785, 69.11608, 80.56928, 110.27956, 135.17042});
        womenDL.put(mWeightWomen.get(152), new Double[]{37.53474, 69.73977, 81.30637, 111.24344, 136.53119});
        womenDL.put(mWeightWomen.get(154), new Double[]{37.93163, 70.36346, 82.04345, 112.20732, 137.89197});
        womenDL.put(mWeightWomen.get(156), new Double[]{38.32852, 70.98715, 82.78054, 113.17120, 139.25274});
        womenDL.put(mWeightWomen.get(159), new Double[]{38.72542, 71.61084, 83.51763, 114.13509, 140.61352});
        womenDL.put(mWeightWomen.get(161), new Double[]{39.12231, 72.23453, 84.25471, 115.09897, 141.97430});
        womenDL.put(mWeightWomen.get(163), new Double[]{39.51920, 72.85822, 84.99180, 116.06285, 143.33507});
        womenDL.put(mWeightWomen.get(165), new Double[]{39.91610, 73.48190, 85.72889, 117.02674, 144.69585});
        womenDL.put(mWeightWomen.get(167), new Double[]{40.25629, 74.16229, 86.57937, 117.87722, 145.26284});
        womenDL.put(mWeightWomen.get(169), new Double[]{40.59648, 74.84268, 87.42986, 118.72771, 145.82983});
        womenDL.put(mWeightWomen.get(173), new Double[]{41.27687, 76.20346, 89.13083, 120.42868, 146.96381});
        womenDL.put(mWeightWomen.get(175), new Double[]{41.61707, 76.88384, 89.98131, 121.27916, 147.53080});
        womenDL.put(mWeightWomen.get(177), new Double[]{41.95726, 77.56423, 90.83180, 122.12965, 148.09779});
        womenDL.put(mWeightWomen.get(179), new Double[]{42.29745, 78.24462, 91.68228, 122.98013, 148.66478});
        womenDL.put(mWeightWomen.get(181), new Double[]{42.63765, 78.92501, 92.53277, 123.83062, 149.23177});
        womenDL.put(mWeightWomen.get(183), new Double[]{43.03454, 79.66210, 93.26986, 124.45431, 150.36575});
        womenDL.put(mWeightWomen.get(185), new Double[]{43.43143, 80.39918, 94.00694, 125.07799, 151.49973});
        womenDL.put(mWeightWomen.get(187), new Double[]{43.82833, 81.13627, 94.74403, 125.70168, 152.63371});
        womenDL.put(mWeightWomen.get(189), new Double[]{44.22522, 81.87336, 95.48112, 126.32537, 153.76769});
        womenDL.put(mWeightWomen.get(192), new Double[]{44.62211, 82.61044, 96.21820, 126.94906, 154.90167});
        womenDL.put(mWeightWomen.get(194), new Double[]{45.01901, 83.34753, 96.95529, 127.57275, 156.03565});
        womenDL.put(mWeightWomen.get(196), new Double[]{45.41590, 84.08462, 97.69238, 128.19644, 157.16963});
        womenDL.put(mWeightWomen.get(198), new Double[]{45.81279, 84.82170, 98.42946, 128.82013, 158.30361});

        return womenDL;
    }

    private static HashMap<Integer, Double[]> getPowerCleanWomen() {

        HashMap<Integer, Double[]> womenPC = new HashMap<Integer, Double[]>();

        womenPC.put(mWeightWomen.get(97), new Double[]{14.96854, 27.66911, 31.75144, 42.18406, 53.07026});
        womenPC.put(mWeightWomen.get(99), new Double[]{15.19533, 28.23610, 32.43183, 43.09124, 53.97745});
        womenPC.put(mWeightWomen.get(101), new Double[]{15.42213, 28.80309, 33.11222, 43.99842, 54.88463});
        womenPC.put(mWeightWomen.get(103), new Double[]{15.64892, 29.37008, 33.79260, 44.90561, 55.79182});
        womenPC.put(mWeightWomen.get(105), new Double[]{15.87572, 29.93707, 34.47299, 45.81279, 56.69900});
        womenPC.put(mWeightWomen.get(107), new Double[]{16.21591, 30.39066, 35.15338, 46.60658, 57.83298});
        womenPC.put(mWeightWomen.get(109), new Double[]{16.55611, 30.84426, 35.83377, 47.40036, 58.96696});
        womenPC.put(mWeightWomen.get(112), new Double[]{16.89630, 31.29785, 36.51416, 48.19415, 60.10094});
        womenPC.put(mWeightWomen.get(114), new Double[]{17.23650, 31.75144, 37.19454, 48.98794, 61.23492});
        womenPC.put(mWeightWomen.get(116), new Double[]{17.46329, 32.20503, 37.76153, 49.78172, 62.14210});
        womenPC.put(mWeightWomen.get(118), new Double[]{17.69009, 32.65862, 38.32852, 50.57551, 63.04929});
        womenPC.put(mWeightWomen.get(121), new Double[]{17.91688, 33.11222, 38.89551, 51.36929, 63.95647});
        womenPC.put(mWeightWomen.get(123), new Double[]{18.14368, 33.56581, 39.46250, 52.16308, 64.86366});
        womenPC.put(mWeightWomen.get(125), new Double[]{18.48387, 34.13280, 40.02949, 52.84347, 65.88424});
        womenPC.put(mWeightWomen.get(127), new Double[]{18.82407, 34.69979, 40.59648, 53.52386, 66.90482});
        womenPC.put(mWeightWomen.get(130), new Double[]{19.16426, 35.26678, 41.16347, 54.20424, 67.92540});
        womenPC.put(mWeightWomen.get(132), new Double[]{19.50446, 35.83377, 41.73046, 54.88463, 68.94598});
        womenPC.put(mWeightWomen.get(134), new Double[]{19.73125, 36.28736, 42.24076, 55.56502, 69.79647});
        womenPC.put(mWeightWomen.get(136), new Double[]{19.95805, 36.74095, 42.75105, 56.24541, 70.64695});
        womenPC.put(mWeightWomen.get(138), new Double[]{20.18484, 37.19454, 43.26134, 56.92580, 71.49744});
        womenPC.put(mWeightWomen.get(140), new Double[]{20.41164, 37.64814, 43.77163, 57.60618, 72.34792});
        womenPC.put(mWeightWomen.get(144), new Double[]{20.86523, 38.55532, 44.79221, 58.96696, 74.04889});
        womenPC.put(mWeightWomen.get(146), new Double[]{21.09203, 39.00891, 45.30250, 59.64735, 74.89938});
        womenPC.put(mWeightWomen.get(148), new Double[]{21.31882, 39.46250, 45.81279, 60.32774, 75.74986});
        womenPC.put(mWeightWomen.get(150), new Double[]{21.48892, 39.80270, 46.26638, 60.95143, 76.71375});
        womenPC.put(mWeightWomen.get(152), new Double[]{21.65902, 40.14289, 46.71998, 61.57511, 77.67763});
        womenPC.put(mWeightWomen.get(154), new Double[]{21.82912, 40.48309, 47.17357, 62.19880, 78.64151});
        womenPC.put(mWeightWomen.get(156), new Double[]{21.99921, 40.82328, 47.62716, 62.82249, 79.60540});
        womenPC.put(mWeightWomen.get(159), new Double[]{22.16931, 41.16347, 48.08075, 63.44618, 80.56928});
        womenPC.put(mWeightWomen.get(161), new Double[]{22.33941, 41.50367, 48.53434, 64.06987, 81.53316});
        womenPC.put(mWeightWomen.get(163), new Double[]{22.50950, 41.84386, 48.98794, 64.69356, 82.49705});
        womenPC.put(mWeightWomen.get(165), new Double[]{22.67960, 42.18406, 49.44153, 65.31725, 83.46093});
        womenPC.put(mWeightWomen.get(167), new Double[]{22.90640, 42.58095, 49.95182, 65.94094, 83.97122});
        womenPC.put(mWeightWomen.get(169), new Double[]{23.13319, 42.97784, 50.46211, 66.56463, 84.48151});
        womenPC.put(mWeightWomen.get(173), new Double[]{23.58678, 43.77163, 51.48269, 67.81200, 85.50209});
        womenPC.put(mWeightWomen.get(175), new Double[]{23.81358, 44.16852, 51.99298, 68.43569, 86.01238});
        womenPC.put(mWeightWomen.get(177), new Double[]{24.04038, 44.56541, 52.50327, 69.05938, 86.52267});
        womenPC.put(mWeightWomen.get(179), new Double[]{24.26717, 44.96231, 53.01357, 69.68307, 87.03297});
        womenPC.put(mWeightWomen.get(181), new Double[]{24.49397, 45.35920, 53.52386, 70.30676, 87.54326});
        womenPC.put(mWeightWomen.get(183), new Double[]{24.72076, 45.81279, 53.92075, 70.87375, 88.33704});
        womenPC.put(mWeightWomen.get(185), new Double[]{24.94756, 46.26638, 54.31764, 71.44074, 89.13083});
        womenPC.put(mWeightWomen.get(187), new Double[]{25.17436, 46.71998, 54.71454, 72.00773, 89.92461});
        womenPC.put(mWeightWomen.get(189), new Double[]{25.40115, 47.17357, 55.11143, 72.57472, 90.71840});
        womenPC.put(mWeightWomen.get(192), new Double[]{25.62795, 47.62716, 55.50832, 73.14171, 91.51219});
        womenPC.put(mWeightWomen.get(194), new Double[]{25.85474, 48.08075, 55.90521, 73.70870, 92.30597});
        womenPC.put(mWeightWomen.get(196), new Double[]{26.08154, 48.53434, 56.30211, 74.27569, 93.09976});
        womenPC.put(mWeightWomen.get(198), new Double[]{26.30834, 48.98794, 56.69900, 74.84268, 93.89354});

        return womenPC;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_strength_standards, container, false);

        RadioGroup genderGroup = (RadioGroup) rootView.findViewById(R.id.gender);
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        mGenderIsMale = true;
                        getDropDownList();
                        break;

                    case R.id.female:
                        mGenderIsMale = false;
                        getDropDownList();
                        break;
                }
            }
        });

        RadioGroup unitGroup = (RadioGroup) rootView.findViewById(R.id.unit);
        unitGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.kg:
                        mUnitIsKG = true;
                        getDropDownList();
                        break;

                    case R.id.lb:
                        mUnitIsKG = false;
                        getDropDownList();
                        break;
                }
            }
        });


        Button calculateButton = (Button) rootView.findViewById(R.id.calculate);
        calculateButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                getStrengthStandards();
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Getting the instance of Spinner and applying OnItemSelectedListener on it.
        mWeightSpinner = (Spinner) getActivity().findViewById(R.id.weight_spinner);
        mWeightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                mWeight = Integer.parseInt(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Creating ArrayAdapter and setting data on the Spinner. Default values will be for men in KG.
        getDropDownList();
    }

    private void getDropDownList() {

        if (mGenderIsMale & mUnitIsKG) {
            Arrays.sort(mListMenKG);
            mWeightAdapter = new ArrayAdapter<Integer>(getContext(),
                    android.R.layout.simple_spinner_item, mListMenKG);
            mWeightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mWeightSpinner.setAdapter(mWeightAdapter);
        }

        if (!mGenderIsMale & mUnitIsKG) {
            Arrays.sort(mListWomenKG);
            mWeightAdapter = new ArrayAdapter<Integer>(getContext(),
                    android.R.layout.simple_spinner_item, mListWomenKG);
            mWeightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mWeightSpinner.setAdapter(mWeightAdapter);
        }

        if (mGenderIsMale & !mUnitIsKG) {
            Arrays.sort(mListMenLB);
            mWeightAdapter = new ArrayAdapter<Integer>(getContext(),
                    android.R.layout.simple_spinner_item, mListMenLB);
            mWeightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mWeightSpinner.setAdapter(mWeightAdapter);
        }

        if (!mGenderIsMale & !mUnitIsKG) {
            Arrays.sort(mListWomenLB);
            mWeightAdapter = new ArrayAdapter<Integer>(getContext(),
                    android.R.layout.simple_spinner_item, mListWomenLB);
            mWeightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mWeightSpinner.setAdapter(mWeightAdapter);
        }
    }

    public void getStrengthStandards() {

        if (mGenderIsMale & mUnitIsKG) {
            updateValues(getMilitaryPressFields(), mMilitaryPressMen.get(mWeight));
            updateValues(getBenchPressFields(), mBenchPressMen.get(mWeight));
            updateValues(getSquatFields(), mSquatMen.get(mWeight));
            updateValues(getDeadliftFields(), mDeadliftMen.get(mWeight));
            updateValues(getPowerCleanFields(), mPowerCleanMen.get(mWeight));
        }

        if (!mGenderIsMale & mUnitIsKG) {
            updateValues(getMilitaryPressFields(), mMilitaryPressWomen.get(mWeight));
            updateValues(getBenchPressFields(), mBenchPressWomen.get(mWeight));
            updateValues(getSquatFields(), mSquatWomen.get(mWeight));
            updateValues(getDeadliftFields(), mDeadliftWomen.get(mWeight));
            updateValues(getPowerCleanFields(), mPowerCleanWomen.get(mWeight));
        }

        if (mGenderIsMale & !mUnitIsKG) {
            updateValues(getMilitaryPressFields(), mMilitaryPressMen.get(mWeightMen.get(mWeight)));
            updateValues(getBenchPressFields(), mBenchPressMen.get(mWeightMen.get(mWeight)));
            updateValues(getSquatFields(), mSquatMen.get(mWeightMen.get(mWeight)));
            updateValues(getDeadliftFields(), mDeadliftMen.get(mWeightMen.get(mWeight)));
            updateValues(getPowerCleanFields(), mPowerCleanMen.get(mWeightMen.get(mWeight)));
        }

        if (!mGenderIsMale & !mUnitIsKG) {
            updateValues(getMilitaryPressFields(), mMilitaryPressWomen.get(mWeightWomen.get(mWeight)));
            updateValues(getBenchPressFields(), mBenchPressWomen.get(mWeightWomen.get(mWeight)));
            updateValues(getSquatFields(), mSquatWomen.get(mWeightWomen.get(mWeight)));
            updateValues(getDeadliftFields(), mDeadliftWomen.get(mWeightWomen.get(mWeight)));
            updateValues(getPowerCleanFields(), mPowerCleanWomen.get(mWeightWomen.get(mWeight)));
        }
    }

    private void updateValues(TextView[] fields, Double[] values) {

        DecimalFormat valueTrimmer = new DecimalFormat("#");
        valueTrimmer.setRoundingMode(RoundingMode.HALF_UP);

        for (int i = 0; i < values.length; i++) {
            if (mUnitIsKG) {
                fields[i].setText("" + valueTrimmer.format(values[i]));
            } else {
                fields[i].setText("" + valueTrimmer.format(values[i] * 2.20462));
            }
        }
    }

    private TextView[] getMilitaryPressFields() {
        TextView[] mMilitaryPressFields = {
                (TextView) getActivity().findViewById(R.id.military_cat1),
                (TextView) getActivity().findViewById(R.id.military_cat2),
                (TextView) getActivity().findViewById(R.id.military_cat3),
                (TextView) getActivity().findViewById(R.id.military_cat4),
                (TextView) getActivity().findViewById(R.id.military_cat5)};
        return mMilitaryPressFields;
    }

    private TextView[] getBenchPressFields() {
        TextView[] mBenchPressFields = {
                (TextView) getActivity().findViewById(R.id.bench_cat1),
                (TextView) getActivity().findViewById(R.id.bench_cat2),
                (TextView) getActivity().findViewById(R.id.bench_cat3),
                (TextView) getActivity().findViewById(R.id.bench_cat4),
                (TextView) getActivity().findViewById(R.id.bench_cat5)};
        return mBenchPressFields;
    }

    private TextView[] getSquatFields() {
        TextView[] mSquatFields = {
                (TextView) getActivity().findViewById(R.id.squat_cat1),
                (TextView) getActivity().findViewById(R.id.squat_cat2),
                (TextView) getActivity().findViewById(R.id.squat_cat3),
                (TextView) getActivity().findViewById(R.id.squat_cat4),
                (TextView) getActivity().findViewById(R.id.squat_cat5)};
        return mSquatFields;
    }

    private TextView[] getDeadliftFields() {
        TextView[] mDeadliftFields = {
                (TextView) getActivity().findViewById(R.id.deadlift_cat1),
                (TextView) getActivity().findViewById(R.id.deadlift_cat2),
                (TextView) getActivity().findViewById(R.id.deadlift_cat3),
                (TextView) getActivity().findViewById(R.id.deadlift_cat4),
                (TextView) getActivity().findViewById(R.id.deadlift_cat5)};
        return mDeadliftFields;
    }

    private TextView[] getPowerCleanFields() {
        TextView[] mPowerCleanFields = {
                (TextView) getActivity().findViewById(R.id.power_clean_cat1),
                (TextView) getActivity().findViewById(R.id.power_clean_cat2),
                (TextView) getActivity().findViewById(R.id.power_clean_cat3),
                (TextView) getActivity().findViewById(R.id.power_clean_cat4),
                (TextView) getActivity().findViewById(R.id.power_clean_cat5)};
        return mPowerCleanFields;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
