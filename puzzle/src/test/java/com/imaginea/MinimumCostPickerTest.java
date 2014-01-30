/**
 * 
 */
package com.imaginea;

import org.junit.Test;

/**
 * @author Nitin Gurram [nitin.gurram@imaginea.com]
 * 
 */
public class MinimumCostPickerTest {

    /**
     * Test method for
     * {@link com.imaginea.puzzle.MinimumCostPicker#run(java.lang.String[])}.
     */
    @Test
    public void testRun() {
        try {
            String[] args1 = new String[] { "E:\\sample_data.csv", "burger", "tofu_log" };
            String[] args2 = new String[] { "E:\\sample_data2.csv", "chef_salad", "wine_spritzer" };
            String[] args3 = new String[] { "E:\\sample_data3.csv", "fancy_european_water", "extreme_fajita" };

            String output1 = MinimumCostPicker.run(args1);
            String output2 = MinimumCostPicker.run(args2);
            String output3 = MinimumCostPicker.run(args3);

            System.out.println(output1);
            System.out.println(output2);
            System.out.println(output3);

            org.junit.Assert.assertTrue(output1 != null && output1.contains("2 11.5"));
            org.junit.Assert.assertTrue(output2 == null);
            org.junit.Assert.assertTrue(output3 != null && output3.contains("6 11.0"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
