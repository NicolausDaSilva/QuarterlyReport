import java.text.DecimalFormat;

public class Quarterly_Report {
    public static void main(String[] args) {

        //Going with classes to organise the data as this would be the most realistic way to save data on the DB.
        //Allows for easy calling and to persist.

        MonthlyReport April = new MonthlyReport(4, 67, 65, 63, 18, 16);
        MonthlyReport May = new MonthlyReport(5, 63, 67, 63, 24, 23);
        MonthlyReport June = new MonthlyReport(6, 78, 56, 65, 22, 21);
        MonthlyReport July = new MonthlyReport(7, 78, 45, 71, 19, 19);
        MonthlyReport August = new MonthlyReport(8, 104, 56, 73, 17, 20);
        MonthlyReport September = new MonthlyReport(9, 103, 72, 69, 16, 19);

        //Breaking down data into quarters allows for efficient seperation of points while reduction of error
        //should be noted, that the functions below can calculate for any number of months, thus if you wanted
        //to get the total per department for an year the provided array would only need to be changed
        MonthlyReport[] q2 = new MonthlyReport[]{April, May, June};
        MonthlyReport[] q3 = new MonthlyReport[]{July, August, September};

        //The functions
        totalSalesPerDepartmentPerQuarter(q2, q3);
        getTaxesFromProfits(q2, q3);
        projectedSales(q3);
    }

    static class MonthlyReport{
        private int month;
        private int electrical;
        private int kitchen;
        private int bathroom;
        private int softFurnishing;
        private int accessories;

        public MonthlyReport(int month, int electrical, int kitchen, int bathroom, int softFurnishing, int accessories) {
            this.month = month;
            this.electrical = electrical;
            this.kitchen = kitchen;
            this.bathroom = bathroom;
            this.softFurnishing = softFurnishing;
            this.accessories = accessories;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            if (month == 0 || month > 12){
                System.out.println("month must be between 1 - 12");
                setMonth(1);
            }
            this.month = month;
        }

        public int getElectrical() {
            return electrical;
        }

        public void setElectrical(int electrical) {
            if (electrical==0 || electrical>500){
                System.out.println("Please check with accounting");
            }
            this.electrical = electrical;
        }

        public int getKitchen() {
            return kitchen;
        }

        public void setKitchen(int kitchen) {
            if (kitchen==0 || kitchen>500){
                System.out.println("Please check with accounting");
            }
            this.kitchen = kitchen;
        }

        public int getBathroom() {
            return bathroom;
        }

        public void setBathroom(int bathroom) {
            if (bathroom==0 || bathroom>500){
                System.out.println("Please check with accounting");
            }
            this.bathroom = bathroom;
        }

        public int getSoftFurnishing() {
            return softFurnishing;
        }

        public void setSoftFurnishing(int softFurnishing) {
            if (softFurnishing==0 || softFurnishing>500){
                System.out.println("Please check with accounting");
            }
            this.softFurnishing = softFurnishing;
        }

        public int getAccessories() {
            return accessories;
        }

        public void setAccessories(int accessories) {
            if (accessories==0 || accessories>500){
                System.out.println("Please check with accounting");
            }
            this.accessories = accessories;
        }
    }


    public static String totalSalesPerDepartmentPerQuarter(MonthlyReport[] q2, MonthlyReport[] q3, int... a) {


        //Please note, I wrote this function with this many variables because it seems like the question wanted everything within one function.
        //However it would be more reusable with varargs type of construction

        int electricQ1 = 0;
        int electricQ2 = 0;
        int kitchenQ1 = 0;
        int kitchenQ2 = 0;
        int bathroomQ1 = 0;
        int bathroomQ2 = 0;
        int softFurishingQ1 = 0;
        int softFurnishingQ2 = 0;
        int accessoriesQ1 = 0;
        int accessoriesQ2 = 0;

        for (MonthlyReport month: q2){
            electricQ1 += month.getElectrical();
            kitchenQ1 += month.getKitchen();
            bathroomQ1 += month.getBathroom();
            softFurishingQ1 += month.getSoftFurnishing();
            accessoriesQ1 += month.getAccessories();
        }

        for (MonthlyReport month: q3){
            electricQ2 += month.getElectrical();
            kitchenQ2 += month.getKitchen();
            bathroomQ2 += month.getBathroom();
            softFurnishingQ2 += month.getSoftFurnishing();
            accessoriesQ2 += month.getAccessories();
        }
        String results = "Task 1: Electric q2 = " + electricQ1 + ", Electric q3 = " + electricQ2 + " , kitchen q2 = " + kitchenQ1 + ", kitchen q3 = " + kitchenQ2 +
                " bathroom q2 = " + bathroomQ1 + ", bathroom q3 = " + bathroomQ2 +
                " softFurishing q2 = " + softFurishingQ1 +  " softFurishing q3 = " + softFurnishingQ2 +
                " accessories Q2 = " + accessoriesQ1 +  " accessories Q3 = " + accessoriesQ2;
        System.out.println(results);
        return results;
    }

    public static String getTaxesFromProfits(MonthlyReport[] q2, MonthlyReport[] q3){
        double taxes2 = 0;
        double taxes3 = 0;

        for (MonthlyReport month: q2){
            taxes2 += month.getElectrical();
            taxes2 += month.getKitchen();
            taxes2 += month.getBathroom();
            taxes2 += month.getSoftFurnishing();
            taxes2 += month.getAccessories();
        }

        for (MonthlyReport month: q3){
            taxes3 += month.getElectrical();
            taxes3 += month.getKitchen();
            taxes3 += month.getBathroom();
            taxes3 += month.getSoftFurnishing();
            taxes3 += month.getAccessories();
        }
        taxes2 = taxes2 * .17;
        taxes3 =  taxes3 * .17;
        String results = "Task 4: Taxes for q2 = " + taxes2 + ". Taxes for q3 = " + taxes3;
        System.out.println(results);
        return results;
    }

    public static String projectedSales(MonthlyReport[] q3){
        double total = 0;

        double electrical = 0;
        double kitchen = 0;
        double bathroom = 0;
        double softFurnishiing = 0;
        double accessories = 0;

        for (MonthlyReport month: q3){
            electrical += month.getElectrical();
            kitchen += month.getKitchen();
            bathroom += month.getBathroom();
            softFurnishiing += month.getSoftFurnishing();
            accessories += month.getAccessories();
        }

        String result = "Task 5: Projected sales for electrical " + projectgrowth(electrical) + " projected sales for kitchen " + projectgrowth(kitchen)
                + " projected sales for bathroom " + projectgrowth(bathroom) + " projected sales for softFurnishiing " + projectgrowth(softFurnishiing) +
                " projected sales for accessories " + projectgrowth(accessories);
        System.out.println(result);
        return result;
    }

    //Created a growth average predictor function
    public static String projectgrowth(double sales){
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format((sales/3)*1.12);
    }
}