package ar.uba.dc.so.memoryManagement;

import ar.uba.dc.so.domain.Partition;
import ar.uba.dc.so.domain.Process;

public class MemoryFixedPartition extends Memory {
	public final int partitionSizeInKb;
	
	public MemoryFixedPartition(int sizeInKb, int partitionSizeInKb) throws Exception {
		super(sizeInKb);
		if (sizeInKb % partitionSizeInKb != 0)
			throw new Exception("The partition size must be divider of the memory size.");
		this.partitionSizeInKb = partitionSizeInKb;
		int numberOfPartitions = getNumberOfPartition();
		for (Integer p = 1; p <= numberOfPartitions; p++)
			partitions.add(new Partition(this.partitionSizeInKb));
	}

	@Override
	public boolean alloc(Process process) {
		if (partitionSizeInKb < process.sizeInKb)
			return false;
		for (Partition partition : partitions) {
			if (partition.isEmpty()) {
				partition.setProcessId(process.id);
				usedSizeInKb += partitionSizeInKb;
				return true;
			}
		}
		return false;
	}
	
	private int getNumberOfPartition() {
		return sizeInKb / partitionSizeInKb;
	}
}
