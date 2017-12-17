package runner;

import java.util.concurrent.Callable;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import xls.AsianUtils;
import xls.DrawUtils;
import xls.HomeUtils;

public class RunnerDraws implements Callable<Float> {

	public HSSFSheet sh;
	public int year;

	public RunnerDraws(HSSFSheet sh, int year) {
		this.sh = sh;
		this.year = year;
	}

	@Override
	public Float call() throws Exception {
		Float profit = HomeUtils.realistic(sh, year);
		// System.out.println("Profit for " + sh.getSheetName() + " " + year + "
		// is: " + String.format("%.2f", profit));
		return profit;
	}
}
