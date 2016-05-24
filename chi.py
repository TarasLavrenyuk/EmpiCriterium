from scipy.stats import chi2
print 'min %s', chi2.isf(q=0.95, df=12)
print 'max %s', chi2.isf(q=0.05, df=12)
