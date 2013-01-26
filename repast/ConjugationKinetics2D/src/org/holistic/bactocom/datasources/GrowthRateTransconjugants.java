package org.holistic.bactocom.datasources;

import org.holistic.bactocom.ModelRatesHelper;


import repast.simphony.context.Context;
import repast.simphony.data2.AggregateDataSource;


/**
 * Data Source for General growth rate. 
 * "Experimental validation of a kinetic numerical model of bacterial conjugation"   
 * 
 * 
 * @author APG, ARPA
 *
 */
public class GrowthRateTransconjugants implements AggregateDataSource {
		
	@Override
	public String getId() {
		return "Transconjugants growth rate";
	}

	@Override
	public Class<?> getDataType() {
		return int.class;
	}

	@Override
	public Class<?> getSourceType() {
		return Context.class;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object get(Iterable<?> objs, int size) {
		Context context = (Context) objs.iterator().next();
		ModelRatesHelper.getInstance().gatherData();
		double MU= (double) ModelRatesHelper.getInstance().getGrowthRateTransconjugant(context);
		return MU;
	}

		@Override
		public void reset() {
		}

}
