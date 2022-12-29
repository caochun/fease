// 主合同
db.contract_main_info_res.find({"uniqueId":"0000000489" }) 

// 客户（承租人）
db.customer_basic_info_res.find({"uniqueId":'000000000681'}) 

// 项目基本信息（项目基本信息下关联一个或多个项目方案）
db.project_basic_info_res.find({_id:'201900231'})  

// 项目方案
db.project_quotation_info_res.find({_id:'201900231qut'}) 

// 放款
db.contract_loan_info_res.find({'content.formData.contractId':'0000000489'}) 

// 项目方案、合同、放款阶段分别生成的租金表
db.rent_collection_res.find({'content.quotationId':{'$in':['201900231qut','0000000489','000000000171']}}) 

// 从合同（包括买卖合同、担保合同等）
db.contract_accessory_info_res.find({'content.formData.mainContractUniqueId':'0000000489'})  

// 资产-担保物（担保从合同中记录关联的担保物id）
db.assets_collateral_info_res.find({uniqueId:'63a955e693e4e61794a9ccc6'})  

// 资产-租赁物资产包（主合同、买卖合同中都可能记录资产包id）
db.assets_lease_itempackage_res.find({uniqueId:{$in:['000000000408_0000000489','63a9555a93e4e61794a9ccc3']}}) 

// 资产-租赁物资产清单（资产包下包含资产清单，租赁物的具体信息）
db.assets_lease_item_res.find({'content.formData.leasePackageId':{$in:['000000000408_0000000489','63a9555a93e4e61794a9ccc3']}}) 

// 有效应收款项，以实际放款为单位生成一份最终结果，其中会记录应收和实收信息
db.account_receivable.find({'content.contractId':'0000000961'})  

// 摊销表（按照有效应收款项生成，分为利息摊销和费用摊销信息）
db.amort_collection.find({'content.formData.contractId':'0000000489'}) 

// 凭证信息（应收应付款项实际发生交易时记录的账务信息）
db.voucher_entity.find({'content.assitsItems.contractId':'0000000489'}) 

// 开票信息（应收款项对应开具发票时生成的发票开具信息）
db.bill_info.find({'content.formData.contractId':'0000000489'}) 